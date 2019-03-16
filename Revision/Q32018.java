public class Q32018 {
	public static int[] min_max(int x, int y, int z) {
		int min = x;
		if(y < min) min = y;
		if(z < min) min = z;
		int max = x;
		if (y > max) max = y;
		if (z > max) max = z;
		int[] a = { min, max };
		return a;
	}
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
		int[] a = (min_max(x, y, z));
		for (int i=0; i< a.length; ++i)
			System.out.println(a[i]);
	}
}