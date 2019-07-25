/*package LeetcodeProblems.Strings;
Given a 32-bit signed integer, reverse digits of an integer.
Example 1:
Input: 123
Output: 321
/**
 * ReverseInteger
 */
public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            // last digit = x%10
            res = (res * 10) + x % 10;
            x = x/10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int)res;
    }
    //client
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        int x = 123;
        int y = r.reverse(x);
    }    
}