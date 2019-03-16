public class Average {
	public static void main(String[] args) {
		int n = 0;
		double sum = 0;
		while (!StdIn.isEmpty()) {
			double x = StdIn.readDouble();
			sum += x;
			n++;
		}
		double average = sum /n;
		StdOut.println("Average is " + average);
	}
}