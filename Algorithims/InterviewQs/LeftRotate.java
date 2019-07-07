/*A left rotation operation on an array shifts each of the array's elements  unit to the left. 
For example, if  left rotations are performed on array , then the array would become .
Given an array a of n integers and a number, d, perform  left rotations on the array. 
Return the updated array to be printed as a single line of space-separated integers.
*/
import java.io.*;
public class LeftRotate {
	public static int[] rotLeft(int[]a, int d)
	{
		for (int i=0;i<d;i++) 
		{
			rotLeft(a);
		}
		return a;
	}
	private static int[] rotLeft(int[]a)
	{
		int n = a.length;
		int i, temp;
		temp = a[0];
		for (i=0;i<n-1;i++) 
		{
			a[i] = a[i+1];
		}
		a[i] = temp;
		return a;
	}
	//driver code
	public static void main(String[] args) {
		int d = Integer.parseInt(args[0]);
		int[] in = { 1, 3, 5, 4, 2};
		int[] out = rotLeft(in, d);
		for (int i=0;i<out.length;i++) {
			System.out.println(out[i]);
		}
	}
}