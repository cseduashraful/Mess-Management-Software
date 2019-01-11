package stermip.mess.functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stermip.mess.Main;

public class registerMember {

	public static boolean register(JTextField[] memberList, int count) {
		// TODO Auto-generated method stub
		for(int i=0;i<count;i++){
			boolean bl = processInsertion(memberList[i].getText());
			if(bl==false) {
				//deleteMembers();
				return false;
			}
		}
		return true;
		
	}
	
	private static void deleteMembers() {
		// TODO Auto-generated method stub
		try{
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = "delete from member";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.execute();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);

		}
	}

	private static boolean processInsertion(String name){
		try{
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = "INSERT INTO member "
	            + "(NAME,room) VALUES"
	            + "(?,0)";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.setString(1,name);
			sql_statement.execute();
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}

}
