public class arrayexamples {
	private int x = 4;
	public static double avg(double[] a) {
		double sum = 0.0;
		for (int i =0; i< a.length; ++i)
			sum += a[i];
		return sum/a.length;
	}

	public static double dot(double[]a, double[]b){
		double sum = 0.0;
		for (int i=0; i < a.length; ++i)
			sum += a[i]* b[i];
		return sum;
	}
}

public class error {
	public static int errchk(int y) {
		int sum = x * y;
		y = 6;
	}
}