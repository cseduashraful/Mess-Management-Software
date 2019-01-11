package stermip.mess.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import stermip.mess.Main;

public class memberCheck {

	public static boolean registered() {
		// TODO Auto-generated method stub
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select * from member";
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

	public static int getMemberCount() {
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select members from manager";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int nom=0;
			while(rs.next()){
				nom = rs.getInt("members");
			}
			return nom;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return 0;
		}
	}

	public static ArrayList<String> getMembers() {
		// TODO Auto-generated method stub
		ArrayList<String>members = new ArrayList<String>();
		
		try{
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select * from member";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String m = rs.getString("name");
				members.add(m);
			}
			return members;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
