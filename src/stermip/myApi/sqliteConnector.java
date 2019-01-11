package stermip.myApi;
import java.sql.*;
import javax.swing.*;
public class sqliteConnector {
	public static Connection conn = null;
	public static Connection getConnection(){
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data\\messManagement.sqlite");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
