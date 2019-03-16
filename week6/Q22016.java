public class Q22016 {
	public static boolean allequal(int[]a) {
		if (a == null) return true;
		int first = a[0];
		for (int i=1; i<a.length; ++i) {
			return a[i] == a[0];
		}
		return false;
	}
	public static void main(String[] args) {
		while (!StdIn.isEmpty()) {
			int x = StdIn.readInt();
			int[]b = { x };
			System.out.println(allequal(b));
		}					
	}
}