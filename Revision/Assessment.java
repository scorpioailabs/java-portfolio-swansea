public class Assessment {
	static long sum(int[] a) {
		long s = 0;
  		for (int i=0; i <= a.length; ++i) s += a[i];
  		return s;
	}
}