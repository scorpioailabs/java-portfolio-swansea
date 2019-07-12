/*package InterviewQs;
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
/**
 * LongestSubstring
 */
import java.util.*;

public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        char[] ch = s.toCharArray();
        return longestSubstring(ch, k, 0, s.length());
    }

    private int longestSubstring(char[] ch, int k, int start, int end) {
        // base
        if (end - start < k)
            return 0; // i.e. substring length shorter than k
        int[] count = new int[26];
        for (int i = start; i < end; ++i) {
            count[ch[i] - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            return end - start;
        }
        int longest = 0;
        int i = start;
        for (int j = 0; j < end; j++) {
            if (count[ch[j] - 'a'] < k) {
                longest = Math.max(longest, longestSubstring(ch, k, i, j));
                i = j + 1;
            }
        }
        longest = Math.max(longest, longestSubstring(ch, k, i, end));
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        String s = "aaabbccccccdddddefffggghhhiijjkllmnopqrstuvvvvvvwwwwwwwwwwyyyyyzzzz";
        int k = Integer.parseInt(args[0]);
        int res = l.longestSubstring(s, k);
        System.out.println(res);
    }
}