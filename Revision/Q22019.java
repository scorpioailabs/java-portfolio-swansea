public class Q22019 {
	public static boolean is_different(int[] a) {
		if (a == null) return false;
		if (a.length <= 1) return false;
		for (int i=0; i < a.length -1; ++i)
			if (a[i] == a[i + 1]) return false;
		return true;
	}
		public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int[]x = { a, b, c };
		System.out.println(is_different(x));
	}
}