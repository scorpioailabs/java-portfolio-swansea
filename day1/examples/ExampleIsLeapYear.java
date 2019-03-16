package day1.examples;

public class ExampleIsLeapYear {

	public static void main(String[] args) {
		int year = Integer.parseInt(args[0]);
		boolean isLeapYear;
		
		// divisible by 4 but not 100
		isLeapYear = (year % 4 == 0) && (year % 100 != 0);
		
		// OR is divisible by 400
		isLeapYear = isLeapYear || (year % 400 == 0);
		
		System.out.println(isLeapYear);
	}

}
