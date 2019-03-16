public class Exercise5 {
	public static void main(String[]args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		if (x > 0 && y > 0){
		
			System.out.println(x % y == 0 || y % x == 0);	
		}
		else{
			System.err.println("You must enter a positive integer");
			return;
		}
	}
}
