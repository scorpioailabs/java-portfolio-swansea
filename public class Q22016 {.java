public class Q22016 {
	public static boolean allequal(int[]a) {
		if (a == null) return true;
		for (int i=0; i<a.length; ++i) {
			for (int j= i + 1; j < a.length; ++j) {
				return a[i] == a[j];
			}
		}
		return false;
	}
	public static void main(String[] args) {
		while (!StdIn.isEmpty()) {
			int args = StdIn.readInt();
			int[]b = { args };
		}
						
	}
}