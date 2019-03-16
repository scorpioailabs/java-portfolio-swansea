public class Functions {
	public static int sum_min_max(int x, int y, int z) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int [] a = { x, y, z };
		for (int i=0; i<=2; i++)
			if (a[i] > max) max = a[i];
			for (int j=0; j<=2; j++)
				if (a[j] < min) min = a[j];
		return min + max;
	}
	public static void main(String[]args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		System.out.println(sum_min_max(a, b, c));
	}
}