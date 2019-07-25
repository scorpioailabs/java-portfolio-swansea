/*package LeetcodeProblems.Strings;
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.
Example 1:
Input: 1
Output: "1"
/**
 * CountSay
 */
public class CountSay {
    public String countAndSay(int n) {
        return helper(n, "1");     
    }    
    public String helper(int n, String str) {
        if(n==1) return str;
        StringBuilder sb = new StringBuilder();
        char[] nums = str.toCharArray();
        char pre = nums[0];
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]== pre) freq++;
            else {
                sb.append(freq);
                sb.append(pre);
                pre = nums[i];
                freq = 1;
            }
        }
        sb.append(freq);
        sb.append(pre);
        return helper(n-1, sb.toString());        
    }
    public static void main(String[] args) {
        CountSay c = new CountSay();
        int n = 8;
        c.countAndSay(n);
    } 
}