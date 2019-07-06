import java.util.*;
import java.io.*;
import java.math.*;
class SolutionTwo {
	public static void main(String[] args) {
		Solutions sol = new Solutions();
		Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		int nxt = in.nextInt();
		int n = nxt + 1;
		String [] arr = new String[n];
		for (int i =0;i<n;i++) {
			arr[i] = in.nextLine();
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}
}