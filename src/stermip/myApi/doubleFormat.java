package stermip.myApi;

public class doubleFormat {
	public static double transform(double value, int digit){
		int temp;
		value = Math.pow(10,digit)*value;
		temp =(int) value;
		value = temp;
		value = value/ Math.pow(10,digit);
		return value;
	}
}
