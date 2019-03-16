public class Q12017 {
	public static int sum_min_max(final int x, final int y, final int z) {
		int max = x;
		if (y > max) max = y;
		if (z > max) max = z;
		int min = x;
		if (y < min) min = y;
		if (z < min) min = z;
		return(min + max);
	}
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		System.out.println(sum_min_max(a,b,c));
	}
}