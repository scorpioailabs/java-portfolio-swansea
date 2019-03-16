package day1.examples;

public class ExampleArrays {

	public static void main(String[] args) {
		
/*		
  		multiple ways of inputting ints:
  		int a = 5;
		int b = 10;
		int c, d, e;
		c = 30; d = 35; e = 45;*/
		
/*		int a1 = 10;
		int a2 = 20;*/
		
		// best way to store a large amount of data is as per below. Above methods are inefficient.
		int [] a = {10, 20, 30, 40, 50};
		
		System.out.println(a[2] + " " + a[4]);
		
		//enhanced for statement
		for (int temp : a ) {
			System.out.println(temp);
		}
		
		int[] x = new int[5];
		
		x[3] = 26;
		x[1] = 10;
		
		for (int temp2 : x) {
			System.out.println(temp2);

		}
		
		// Can also create String arrays:
		System.out.println("-----------");
		String [] stx = new String[5]; //<---- the 5 in box means an array containing 5 values
		
		stx[3] = "25";
		stx[0] = "2";
		for (String temps2: stx) {
			System.out.println(temps2);
			//note instead of 0 you get "null" in empty arrays.
				
		/*String[] st = {"one", "two", "three"};
		
		for (String temps : st) {
			System.out.println(temps);*/
		}
		
		
		
	}

}
