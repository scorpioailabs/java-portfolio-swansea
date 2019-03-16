public class ArrayII {
	public static void main(String[]args){
		final int N = 1000;
		final int[] a =  new int [N*N*N*N];   /* N =1000 results in negative array size exception because the number is so large 
												we get bit overflow resulting in sign reversal to negative, if we amend to 200 we get out of memory
												error. by changing N to 10 the program runs fine, as the JVM can handle the memory, and int max value
												has not been reached thus we don't get negative array exceptions! */

	}
}