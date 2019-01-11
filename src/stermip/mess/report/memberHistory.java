package stermip.mess.report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import stermip.mess.Main;

public class memberHistory {
	private static ArrayList<member> members;// = new ArrayList<member>();
	public static  ArrayList<member> getMemberHistory(){
		ArrayList<member>members = new ArrayList<member>();
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select a.name,totalMeal,totalDeposit from";
			sql=sql+" (select name, sum(mealCount) as  totalMeal from meals group by name)";
			sql = sql + " as a left outer join";
			sql = sql+" (select name, sum(amount) as totalDeposit from deposit group by name)";
			sql = sql+"as b on a.name=b.name" ;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				member m = new member(rs.getString("name"),rs.getDouble("totalMeal"),rs.getDouble("totalDeposit"));
				members.add(m);
				
			}
			return members;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		

	}
	/*
	 * select a.name,totalMeal,totalDeposit from
(select name, sum(mealCount) as  totalMeal from meals group by name) as a
left outer join
(select name, sum(amount) as totalDeposit from deposit group by name) as b
on a.name=b.name
 */
}
