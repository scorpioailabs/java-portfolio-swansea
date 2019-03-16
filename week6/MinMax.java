public class MinMax{
	public static void main (String[]args){
		long max = StdIn.readInt();
		long min = max;
		while (!StdIn.isEmpty()){
			long val = StdIn.readInt();
			if (val > max) max = val;
			if (val < min) min = val;
		}
		StdOut.println("maximum = " + max + ", minimum = " + min);		
	}
}