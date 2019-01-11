package stermip.myApi;

public class leapYearTest {
	public static boolean isLeapYear(int year){
		 if ( year%400 == 0)
			    return true;
		 else if ( year%100 == 0)
			    return false;
		else if ( year%4 == 0 )
			    return true;
		else
			    return false;
	}
	
	public static int daysOfMonth(String month, int year){
		if(month.equalsIgnoreCase("January")) return 31;
		if(month.equalsIgnoreCase("March")) return 31;
		if(month.equalsIgnoreCase("April")) return 30;
		if(month.equalsIgnoreCase("May")) return 31;
		if(month.equalsIgnoreCase("June")) return 30;
		if(month.equalsIgnoreCase("July")) return 31;
		if(month.equalsIgnoreCase("August")) return 31;
		if(month.equalsIgnoreCase("September")) return 30;
		if(month.equalsIgnoreCase("October")) return 31;
		if(month.equalsIgnoreCase("November")) return 30;
		if(month.equalsIgnoreCase("December")) return 31;
		if(isLeapYear(year)) return 29;
		return 28;
	}
}
