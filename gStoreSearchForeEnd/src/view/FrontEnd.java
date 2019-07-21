package view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class FrontEnd{
	JFrame ctlFrame = new JFrame("Carl Wong gStore Query");
	JPanel panelContent = new JPanel();

	JLabel labelDBName = new JLabel("Database Name");
	JTextField textName = new JTextField(20);
	
	JLabel labelQueryFile = new JLabel("Query File", JLabel.LEADING);
	JTextField textFile = new JTextField(20);   //sparql�ļ���TextField
	JButton buttonChooseFile = new JButton("choose a file");   //ѡ��sparql�ļ��İ�ť
	JLabel labelWarning = new JLabel();     //������ʾlabel
	JTextArea textQueryArea = new JTextArea(6, 40); //��ʾQuery���ĵ���
	
	JButton buttonConfirm = new JButton("confirm");  //ȷ�ϰ�ť

	//�Ű�
	public void init(){
		ctlFrame.setContentPane(panelContent);
		panelContent.setLayout(new GridBagLayout());
		ctlFrame.setResizable(false);

		

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
		panelContent.add(textQueryArea, constraints2);
		
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
		
		//
	}
	public Translator translator = new Translator();   //FrongEnd �Դ��ķ�����
	public class Translator {
		String strDBName;   //���ݿ������
		String strQuery;    //��ִ�е�strQuery���
		String strRes;     //���ص�ִ�н��

		public void translate(FrontEnd frontEnd) {
		}
	}
}