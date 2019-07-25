/*package LeetcodeProblems.Strings;
Given a string, determine if it is a palindrome,
considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem,
we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
/**
 * ValidPalindrome
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        String str = s.replaceAll("\\s|[^a-zA-Z0-9]", "").toLowerCase();
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            else
                j--;
        }
        return true;
    }
    public boolean naiveApproach(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "").toLowerCase();
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    public boolean somethingBetter(String s) {
        if (s == null || s.length() < 2)
            return true;
        int start =0;
        int end = s.length()-1;
        while(start <= end) {
            //ignore the non-letter and digs i/.e. continue
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if(start<= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        v.isPalindrome(s);
    }    
}