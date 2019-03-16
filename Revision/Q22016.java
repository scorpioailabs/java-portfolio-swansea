public class Q22016 {
	public static boolean allequal(int[]a) {
		if (a == null || a.length <= 1) return true;
		for (int i=1; i<a.length; ++i) {
			if (a[i] != a[0]) {
				return false;
			}
		}
		return true;
	}
	public static boolean allequal(final String[]S) {
		if (S==null || S.length<=1) return true;
		int i = 0; // Find first non-null obj
		while(S[i] == null && i < S.length);
		if (i ==S.length)return true; //i.e. all cells are null
		final String s = S[i];
		for (int j = i +1; j < S.length; ++j)
			if(!s.equals(S[j])) return false;
		return true;
	}
	public static void main(String[] args) {
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int c = Integer.parseInt(args[2]);
	int[]x = { a, b, c };
	System.out.println(allequal(x));						
	}
}