class StdEx2 {
	public static void main(String[]args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int num3 = Integer.parseInt(args[2]);
		if (num1 > num2){
			int temp = num1;    //hold the highest number in a temporary "box" while we put the lower number in it's original box
			num1 = num2;       // num1 was higher so now has taken the place of num2
			num2 = temp;       // num2 now has the value that num1 had; acquired via temporary "box"
		}

		if (num2 > num3){
			int temp = num2;      // the same as above this time for "boxes" num2 and num3!
			num2 = num3;
			num3 = temp;
		}

		//now if above condition is met i.e. num 1 is now num 3 then we must account for who's value is bigger the new num2 or the original num2:

		if (num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}

		System.out.println(num1 + " " + num2 + " " + num3);
	}

}