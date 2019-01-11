package stermip.mess.functions;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;



import stermip.mess.Main;
import stermip.myApi.CryptWithMD5;

public class checkPassword {
	public static boolean isMatched(String pass){
		pass = CryptWithMD5.cryptWithMD5(pass);
		String savedPass = null;
		try
        {
			Connection conn = Main.conn;
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where status='active'" ;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				savedPass = rs.getString("password");
			}
			if(pass.equals(savedPass))
            return true;
			warningMsg.msg="Incorrect Password";
			return false;
        }
        catch (Exception e)
        {
        	warningMsg.msg=e.getMessage();
            return false;
        }
	}
}
