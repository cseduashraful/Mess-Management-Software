package stermip.mess.report;

public class member {
	private double totalMeal;
	private double totalDeposit;
	private String name;
	public member(String name, double meal, double deposit){
		this.name=name;
		this.totalDeposit= deposit;
		this.totalMeal=meal;
	}
	public String getName() {
		return name;
	}
	public double getTotalMeal() {
		return totalMeal;
	}
	public double getTotalDeposit() {
		return totalDeposit;
	}
	
}
