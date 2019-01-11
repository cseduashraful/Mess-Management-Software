package stermip.mess.functions;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stermip.mess.Main;

public class depositCheck {

	public static boolean performDeposit(Choice memberChoice,
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

}
