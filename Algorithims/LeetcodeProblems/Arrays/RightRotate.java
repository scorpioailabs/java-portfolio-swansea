/*A right rotation operation on an array shifts each of the array's elements  unit to the right. 
For example, if  right rotations are performed on array , then the array would become .
Given an array a of n integers and a number, d, perform  right rotations on the array. 
Return the updated array to be printed as a single line of space-separated integers.
*/
import java.io.*;
public class RightRotate {
	public static int[] rotRight(int[]a, int d)
	{
		for (int i=d;i>0;i--) 
		{
			rotRight(a);
		}
		return a;
	}
	private static int[] rotRight(int[]a)
	{
		int n = a.length;
		int i, temp;
		temp = a[n-1];
		for (i= n-1;i>0;i--) 
		{
			a[i] = a[i-1];
		}
		a[i] = temp;
		return a;
	}
	//driver code
	public static void main(String[] args) {
		int d = Integer.parseInt(args[0]);
		int[] in = { 1, 3, 5, 4, 2};
		int[] out = rotRight(in, d);
		for (int i=0;i<out.length;i++) {
			System.out.println(out[i]);
		}
	}
}