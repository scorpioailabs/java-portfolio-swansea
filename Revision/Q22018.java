public class Q32018 {
	public static int[2]a min_max(final int x, final int y, final int z) {
		int min = x;
		if(y < min) min = y;
		if(z < min) min = z;
		int max = x;
		if (y > max) max = y;
		if (z > max) max = z;
		return int[]a = { min, max };
	}
}