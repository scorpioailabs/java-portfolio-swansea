/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
*/
import java.io.*; 
import java.util.*; 
import java.math.*;
public class Fibonacci {

	//recursive approach but naive approach
	public static long fib(long n)
	{
		//base case
		if(n == 0) {  return 0; }
		if(n == 1) {  return 1; }
		//general
		else
		{
			return fib(n-1) + fib(n-2);
		}
	}
    
    //memo array helper method
	public static long[] memo(long n) 
	{  
		long memo[] = new long[(int)n+1];
		return memo;
	}

	//dp memoized approach with recursion
	public static long fib2(long n, long[] memo)
	{
		long res =0;
		//base cases
		if(n == 0) {  return 0; }
		if(memo[(int)n] != 0) {  return memo[(int)n];  }
		if(n==1 || n==2) {  res = 1;  }
		//general case
		else
		{
			res = fib2(n-1, memo) + fib2(n-2, memo);
		}
		memo[(int)n] = res;
		return res;
	}

	//bottom-up approach
	public static BigInteger fib3(int n)
	{
		//conditions
		if(n == 1 || n == 2) { return BigInteger.valueOf(1); }
		BigInteger [] arr = new BigInteger[n+1];
		//we know first two numbers in fib sequence to be 1 so:
		arr[1] = BigInteger.ONE;
		arr[2] = BigInteger.ONE;
		//for the rest of array from index 3 onwards:
		for (int i=3;i<n+1;++i) 
		{
			arr[i] = arr[i-1].add(arr[i-2]);
		}
		//got to end now return the nth element in the array
		return arr[n];
	}


	//driver code
	public static void main(String[] args) {
	    Stopwatch st = new Stopwatch();
		long n = Long.parseLong(args[0]);
		long [] memo = memo(n);
		//Naive approach
		// System.out.println("Value of " + n + "th number in the Fibonacci sequence = " + fib(n));
		//Memoized approach
		// System.out.println("Value of " + n + "th number in the Fibonacci sequence = " + fib2(n, memo));
		//Bottom up approach
		System.out.println("Value of " + n + "th number in the Fibonacci sequence = " + fib3((int)n));
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");
	}
}
