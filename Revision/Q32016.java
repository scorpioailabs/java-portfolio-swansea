public class Q32016 {
	public static void swap(int[] a, int[] b) {
		final int[] t = a; a = b; b = t;
	}
	public static void main(final String[] args) {
		final String a = "1 = " + 1/2 + 1/2;
		final String b = "1 = " + (1/2 + 1/2);
		System.out.println(a); // Outputs 1 = 00
		/* Reason for this output is because 
		 it converts the first 1/2 to string then
		 concatenates it followed by next conversion
		 then concatenates*/
		System.out.println(b); // Outputs 1 = 0
		/* Reason for this output is same as above
		Except in this case the brackets mean that we first
		Add the two values in there AND then do toString followed
		by Concatenation*/
		System.out.println(1/2 + 1/2);
		int w = Integer.parseInt(args[0]);
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		int z = Integer.parseInt(args[3]);
		int[] c;
		int[] d;
		swap(c, d);

	}
}