package day1.examples;

public class ExampleDoWhile {

	public static void main(String[] args) {
	
		int x = 10;
		
		do {
			System.out.println("x = " + x);
			x --;
		}while(x > 0);
		// difference to while loop is that, the do-while loop prints statement at least once
		// before verifying the condition.
	}

}
