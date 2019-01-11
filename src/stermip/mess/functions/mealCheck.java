package stermip.mess.functions;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stermip.mess.Main;

public class mealCheck {

	public static boolean performInsertion(Choice memberChoice,
			Choice dateChoice, JTextField amountTf) {
		// TODO Auto-generated method stub
		try{
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = "INSERT INTO deposit "
	            + "(NAME,date,amount) VALUES"
	            + "(?,?,?)";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.setString(1,memberChoice.getSelectedItem());
			int date = Integer.parseInt(dateChoice.getSelectedItem());
			double amount = Double.parseDouble(amountTf.getText());
			sql_statement.setInt(2,date);
			sql_statement.setDouble(3, amount);
			sql_statement.execute();
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
		
		

	}

	public static boolean performInsertion(ArrayList<String> members,
			JTextField[] meals, Choice dateChoice) {
			for(int i=0;i<members.size();i++){
				boolean bl=insert(members.get(i),dateChoice,meals[i]);
				if(bl==false) return false;
			}
		
		
		return true;
	}

	private static boolean insert(String name, Choice dateChoice,
			JTextField amountTf) {
		// TODO Auto-generated method stub
		try{
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = "INSERT INTO meals "
	            + "(NAME,date,mealCount) VALUES"
	            + "(?,?,?)";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.setString(1,name);
			int date = Integer.parseInt(dateChoice.getSelectedItem());
			double amount = Double.parseDouble(amountTf.getText());
			sql_statement.setInt(2,date);
			sql_statement.setDouble(3, amount);
			sql_statement.execute();
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
			return false;
		}
	

	}

	
	public static boolean deleteMealOf(int date){
		try{
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = "delete from meals where date="+date;
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.execute();
			return true;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
			return false;
		}
	}
	

}
