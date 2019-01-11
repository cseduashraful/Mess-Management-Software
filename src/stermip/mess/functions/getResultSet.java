package stermip.mess.functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import stermip.mess.Main;

public class getResultSet {

	public static ResultSet executeQuery(String string) {
		// TODO Auto-generated method stub
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = string;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static boolean updateQuery(String string) {
		// TODO Auto-generated method stub
		try{
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = string;
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.execute();
			return true;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}

}
