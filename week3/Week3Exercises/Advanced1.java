public class Advanced1 {
	public static void main(String[]args) {
		final int N = Integer.parseInt(args[0]);
		long sum = 0;
		for (int i =0; i <= N;) sum += ++i; 
		System.out.println(sum);
	}
}
