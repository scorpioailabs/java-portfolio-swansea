import java.util.*;
import java.io.*;
import java.math.*;
class Solutions {
	public long luckyNumbers(long l, long h)
	{
		int count =0;
		boolean isLucky =false;
		for(long i=l; i<h; i++)
		{
			String s = String.valueOf(i);
			if(s.contains("6") && s.contains("8"))
				isLucky = false;
			else if(s.contains("6") || s.contains("8"))
				isLucky = true;
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Solutions sol = new Solutions();
		Scanner in = new Scanner(System.in);
		long l = in.nextLong();
		long h = in.nextLong();
		long n = sol.luckyNumbers(l, h);
		System.out.println(n);
	}
}