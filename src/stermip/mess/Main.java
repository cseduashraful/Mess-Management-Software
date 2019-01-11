package stermip.mess;
import java.sql.Connection;
import java.util.ArrayList;

import stermip.mess.report.deposit;
import stermip.mess.report.member;
import stermip.mess.report.memberHistory;
import stermip.mess.report.summary;
import stermip.myApi.sqliteConnector;
public class Main {
	public static Connection conn=null;
	/**
	 * @param args
	 */
	public static boolean status = false; 
	public static void main(String[] args) {
		conn=sqliteConnector.getConnection();
		if(conn!=null)
		welcome.showMe();
		/*System.out.println(summary.mealRate());
		ArrayList<member>m = memberHistory.getMemberHistory();
		for(int i=0;i<m.size();i++){
			member mm =m.get(i);
			System.out.println(mm.getName()+" "+mm.getTotalDeposit()+" "+mm.getTotalMeal());
		}*/
	}

}
