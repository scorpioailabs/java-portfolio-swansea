/*package LeetcodeProblems.Strings;
Write a function that reverses a string. 
The input string is given as an array of characters char[].
Do not allocate extra space for another array, 
you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.
Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
/**
 * ReverseString
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int j = s.length-1;
        for (int i = 0; i<s.length/2; i++) {
           swap(s, i, j);
           j--;
        } 
    }
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}