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
	JTextField textFile = new JTextField(20);   //sparql文件名TextField
	JButton buttonChooseFile = new JButton("choose a file");   //选择sparql文件的按钮
	JLabel labelWarning = new JLabel();     //警告提示label
	JTextArea textQueryArea = new JTextArea(6, 40); //显示Query的文档域
	
	JButton buttonConfirm = new JButton("confirm");  //确认按钮

	//排版
	public void init(){
		ctlFrame.setContentPane(panelContent);
		panelContent.setLayout(new GridBagLayout());
		ctlFrame.setResizable(false);

		

		//数据库名称模块
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
		
		//加入文件选择模块
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
		
		//加入confirm按钮
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
		//添加事件管理机制

		//主窗口被关闭后，退出程序
		ctlFrame.addWindowListener(new WindowAdapter() {
			public void WindowClosed(WindowEvent e){
				System.exit(0);
			}
		});
		
		//
	}
	public Translator translator = new Translator();   //FrongEnd 自带的翻译器
	public class Translator {
		String strDBName;   //数据库的名称
		String strQuery;    //待执行的strQuery语句
		String strRes;     //返回的执行结果

		public void translate(FrontEnd frontEnd) {
		}
	}
}