package view;


import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.imageio.IIOException;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FrontEnd{
	JFrame ctlFrame = new JFrame("Carl Wong gStore Query");
	JPanel panelContent = new JPanel();

	JLabel labelDBName = new JLabel("Database Name");
	JTextField textName = new JTextField(20);
	
	JLabel labelQueryFile = new JLabel("Query File", JLabel.LEADING);
	JTextField textFile = new JTextField(20);   //sparql�ļ���TextField
	JButton buttonChooseFile = new JButton("choose a file");   //ѡ��sparql�ļ��İ�ť
	FileDialog fileDialog = new FileDialog(ctlFrame, "choose a Sparql file", FileDialog.LOAD);
	JLabel labelWarning = new JLabel();     //������ʾlabel
	JTextArea textAreaQuery = new JTextArea(6, 40); //��ʾQuery���ĵ���
	
	JButton buttonConfirm = new JButton("confirm");  //ȷ�ϰ�ť

	public class Translator {
		String strDBName;   //���ݿ������
		String strQuery;    //��ִ�е�strQuery���
		String strRes;     //���ص�ִ�н��

		String strSparqlDir;  //Sparql �ļ���·��
		public void translate(FrontEnd frontEnd) {
		}
	}
	public Translator translator = new Translator();   //FrongEnd �Դ��ķ�����

	//�Ű�
	public void init(){
		ctlFrame.setContentPane(panelContent);
		panelContent.setLayout(new GridBagLayout());
		//ctlFrame.setResizable(false);

		

		//���ݿ�����ģ��
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridy = 0; constraints.gridx = 0;
		constraints.anchor = constraints.CENTER;
		panelContent.add(labelDBName, constraints);
		
		constraints.gridy = constraints.gridy + constraints.gridheight; 
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		panelContent.add(textName, constraints);
		
		constraints.gridy = constraints.gridy + constraints.gridheight; 
		constraints.gridx = 0;
		panelContent.add(new JPanel(), constraints);
		
		//�����ļ�ѡ��ģ��
		GridBagConstraints constraints2 = new GridBagConstraints();

		constraints2.gridy = constraints.gridy + 1; 
		constraints2.gridx = 0;
		constraints2.gridwidth = 1;
		constraints2.anchor = constraints2.CENTER;
		panelContent.add(labelQueryFile, constraints2);
		
		constraints2.gridy = constraints2.gridy + constraints2.gridheight; 
		constraints2.gridx = 0;
		constraints2.gridwidth = 2;
		panelContent.add(textFile, constraints2);
		
		constraints2.gridy = 5; constraints2.gridx = 0;
		constraints2.gridwidth = 1;
		panelContent.add(buttonChooseFile, constraints2);
		constraints2.gridy = 5; constraints2.gridx = 1; 
		constraints2.gridwidth = 2;
		panelContent.add(labelWarning, constraints2);
		
		constraints2.gridy = 6; constraints2.gridx = 0;
		constraints2.gridheight = 6; constraints2.gridwidth = 4;
		JScrollPane scrollPane = new JScrollPane(textAreaQuery);
		panelContent.add(scrollPane, constraints2);
		//panelContent.add(textAreaQuery, constraints2);
		
		constraints2.gridy = constraints2.gridy + constraints2.gridheight; 
		constraints2.gridx = 0;
		constraints2.gridheight = 1; constraints2.gridwidth = 4;
		panelContent.add(new JPanel(), constraints2);
		
		//����confirm��ť
		GridBagConstraints constraints3 = new GridBagConstraints();
		constraints3.gridy = constraints2.gridy + constraints2.gridheight;
		constraints3.gridx = 0;
		constraints3.gridwidth = 1;
		constraints3.anchor = constraints3.CENTER;
		constraints3.fill = constraints3.BOTH;
		panelContent.add(buttonConfirm, constraints3); 

		arrangeEvents();   //�����¼��������

		ctlFrame.pack();
		ctlFrame.setVisible(true);
	}

	private void arrangeEvents(){
		//����¼��������

		//�����ڱ��رպ��˳�����
		ctlFrame.addWindowListener(new WindowAdapter() {
			public void WindowClosed(WindowEvent e){
				System.exit(0);
			}
		});
		
		//��sparql�ļ�
		buttonChooseFile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ѡ��sparql�ļ�
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter extFilter = new 
						FileNameExtensionFilter("query files *.sql", "sql");
				fileChooser.setFileFilter(extFilter);

				int iRetVal = fileChooser.showOpenDialog(ctlFrame);
				if(iRetVal == fileChooser.APPROVE_OPTION) {
					//���ѡȡ�ɹ������ļ��������text field��
					File queryFile = fileChooser.getSelectedFile();
					translator.strSparqlDir = queryFile.getAbsolutePath();
					textFile.setText(queryFile.getName());
					labelWarning.setText("Choosing successed!");
					
					try {
						BufferedReader reader = new BufferedReader(
								new FileReader(queryFile));
						
						String strTextArea = new String();
						String strTmp = null;
						while((strTmp = reader.readLine()) != null) {
							strTextArea += strTmp + "\n";
						}
						
						textAreaQuery.setText(strTextArea);
					}
					catch (IOException ioe) {
						// TODO: handle exception
						ioe.printStackTrace();
					}
				}
				else {
					//���û��ѡ��ɹ�����ô����ı���
					textFile.setText("");
					labelWarning.setText("No valid file is chosen!");
					textAreaQuery.setText("");
				}

				//���ļ���������������text area
			}
		});
		
		buttonConfirm.addActionListener(new ActionListener() {
			//Ϊȷ�ϰ�ť�����¼��������
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				translator.strDBName = textName.getText();
				translator.strQuery = textAreaQuery.getText();
				
				if(translator.strDBName.equals("") || 
						translator.strQuery.equals("")) {
					labelWarning.setText("database name or query text is empty!");
				}
			}
		});
	}
}