package view;


import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class FrontEnd{
	JFrame ctlFrame = new JFrame("Carl Wong gStore Query");
	JPanel panelContent = new JPanel();

	JLabel labelDBName = new JLabel("Database Name");
	JTextField textName = new JTextField(20);
	
	JLabel labelQueryFile = new JLabel("Query File", JLabel.LEADING);
	JTextField textFile = new JTextField();
	JButton buttonChooseFile = new JButton("choose a file");
	JLabel labelWarning = new JLabel();
	JTextArea textQueryArea = new JTextArea(6, 40);
	
	JButton buttonConfirm = new JButton("confirm");

	public void init(){
		ctlFrame.setContentPane(panelContent);
		panelContent.setLayout(new GridBagLayout());
		ctlFrame.setResizable(false);

		ctlFrame.addWindowListener(new WindowAdapter() {
			public void WindowClosed(WindowEvent e){
				System.exit(0);
			}
		});

		//database name
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
		
		//query file and query content
		GridBagConstraints constraints2 = new GridBagConstraints();

		constraints2.gridy = constraints.gridy + 1; constraints2.gridx = 0;
		constraints2.gridwidth = 1;
		constraints2.anchor = constraints2.CENTER;
		panelContent.add(labelQueryFile, constraints2);
		
		constraints2.gridy = constraints2.gridy + constraints2.gridheight; constraints2.gridx = 0;
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
		
		constraints2.gridy = constraints2.RELATIVE; constraints2.gridx = 0;
		constraints2.gridheight = 1; constraints2.gridwidth = 4;
		panelContent.add(new JPanel(), constraints2);
		
		{
			GridBagConstraints constraints = new GridBagConstraints();
			
			constraints.gridy = constraints.RELATIVE; constraints.gridx = 0;
			constraints.gridheight = 1; constraints.gridwidth = 1;
			panelContent.add(buttonConfirm, constraints);
		}

		ctlFrame.pack();
		ctlFrame.setVisible(true);
	}
}