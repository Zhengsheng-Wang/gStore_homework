package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.*;

public class Commander{
	private GstoreConnector gConnector;
	private FrontEnd fEnd;

	static public void main(String args[]){
		Commander commander = new Commander();
		commander.fEnd = new view.FrontEnd(commander);

		commander.fEnd.init();
		
		commander.gConnector = new 
				GstoreConnector("127.0.0.1", 9000, "root", "123456");
	}
	
	public void queryAndPrint(){
		String strDBState = gConnector.show();

		if(!strDBState.contains(fEnd.translator.strDBName)){
			fEnd.setLabelWaring("database is not existing! Loading...");
			/*
			gConnector.build(fEnd.translator.strDBName, "/home/zswong/gStore_data/" + 
			strDBState + ".nt");
			gConnector.load(fEnd.translator.strDBName);
			*/
			fEnd.setLabelWaring("database " + fEnd.translator.strDBName
					+ " is not existing");
		}
		
		fEnd.translator.strRes = 
				gConnector.query(fEnd.translator.strDBName, fEnd.translator.strOutputFormat, 
				fEnd.translator.strQuery);
		fEnd.setLabelWaring("query successed");
		System.out.println(fEnd.translator.strRes);
	}
}
