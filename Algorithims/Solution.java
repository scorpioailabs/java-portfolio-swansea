public class Solution {
	public static String ReverseWords(String input) {
		// Your code goes here
		String strArray[] = input.split(" ");
		String reversed="";
		for (int i= strArray.length - 1; i >= 0; i --) {
			if (i = 0) {
				reversed += strArray[i]
			}
			else
				reversed+=strArray[i] + " ";
		}
		return reversed;
	}
}