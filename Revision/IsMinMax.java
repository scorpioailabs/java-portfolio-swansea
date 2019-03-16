public class IsMinMax {
	public static int minor_max(int x, int y, int z) {
		int min = x;
		if (y < min) min = y;
		if (z < min) min = z;
		if ((x == y) && (x == z)) return x;
		else return min;
	}
	public static void main(String[]args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		System.out.println(minor_max(a, b, c));
	}
}