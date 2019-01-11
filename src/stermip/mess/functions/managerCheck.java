package stermip.mess.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import stermip.mess.Main;
import stermip.mess.report.manager;
import stermip.myApi.leapYearTest;



public class managerCheck {
	public static boolean isManagerFixed(){
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where status='active'" ;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				return true;
			}
			return false;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}

	public static int getNumberOfDays() {
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where status='active'" ;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int dayCount = 0;
			while(rs.next()){
				int year = rs.getInt("year");
				String month = rs.getString("month");
				dayCount=leapYearTest.daysOfMonth(sql, year);
			}
			return dayCount;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return 0;
		}
	}
	public static manager getManager(){
		try{
			Connection conn = Main.conn;
			manager man = new manager();
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where status='active'" ;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				man.setMonth(rs.getString("month"));
				man.setName(rs.getString("name"));
				man.setYear(rs.getInt("year"));
			}
			return man;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
