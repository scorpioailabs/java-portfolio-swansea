import java.util.Arrays;

/*package LeetcodeProblems.Strings;
Given two strings s and t , write a function to determine if t is an anagram of s.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
/**
 * ValidAnagram
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        else if(s.isEmpty() && t.isEmpty()) return true;
        int count = 0;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s.length(); i++) {
            if(s1[i] == s2[i]) {
                count++;
            }
        }
        return count == s.length() ? true : false;
    }    
    
    public boolean somethingBetter(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) {
            if(--freq[c - 'a'] < 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        String s = "anagram";
        String t = "magrnaa";
        v.isAnagram(s, t);
    }
}