package day1.examples;

public class ExampleSwitchCase {

	public static void main(String[] args) {
		int j = 6;
		// also can do String j = "Two"; 
		
		switch(j) {
		
		case 0:
		// and then use case "One":
			System.out.println("Value is 0");
			break;
		case 1:
			System.out.println("Value is 1");
			break;
		case 2:
			System.out.println("Value is 2");
			break;
		case 3:
			System.out.println("Value is 3");
			break;
		default:
			System.out.println("No Value");
			break;
			
		}

	}

}
