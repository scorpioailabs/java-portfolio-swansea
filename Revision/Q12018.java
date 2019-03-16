public class Q12018 {
	public static boolean is_incremented(int[] a) {
		if (a == null) return true;
		for (int i=0; i <a.length-1; ++i) {
			if (a[i] + 1 != a[i + 1]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int[]x = { a, b, c };
		System.out.println(is_incremented(x));
	}
}