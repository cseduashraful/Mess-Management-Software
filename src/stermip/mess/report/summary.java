package stermip.mess.report;

public class summary {
	private static double totalMeal;
	private static double totalBazar;
	private static double totalDeposit;
	private static double mealRate;
	
		public static double getTotalMeal() {
		return totalMeal;
	}

	public static double getTotalBazar() {
		return totalBazar;
	}

	public static double getTotalDeposit() {
		return totalDeposit;
	}

	public static double getMealRate() {
		return mealRate;
	}

		public static double mealRate(){
			totalMeal=meal.getTotalMeal();
			totalBazar=bazar.getTotalBazar();
			mealRate = totalBazar/totalMeal;
			return mealRate;
		}
}
