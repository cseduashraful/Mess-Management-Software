package stermip.mess.report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import stermip.mess.Main;

public class meal {
	public static double getTotalMeal(){
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select sum(mealCount) as tot from meals";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			double totalMeal = 0;
			while(rs.next()){
				totalMeal = rs.getDouble("tot");
			}
			return totalMeal;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
			return 0;
		}
	}
}
