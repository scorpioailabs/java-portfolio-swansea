package day1.examples;

public class ExampleString {

	public static void main(String[] args) {
		
		String x = "James Dean";
		
		System.out.println("Hello " + x);
		
		System.out.println(x.toUpperCase());
		
		System.out.println(x.substring(2, 7));
		
		System.out.println(x.substring(2));
		
		System.out.println(x.charAt(3));
		
		// If you have a number as a string:
		
		String age = "37";
		String salary = "72364.29";
		//To convert string to integer  = Wrapper classes:
		
		int a = Integer.parseInt(age) / 2;
		System.out.println(a);
		
		// use Double to hold decimals
		double s = Double.parseDouble(salary) * .15;
		System.out.println(s);
		
	}

}
