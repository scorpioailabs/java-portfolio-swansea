/*package LeetcodeProblems.Strings;
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: ["flower","flow","flight"]
Output: "fl"
/**
 * LongestCommonPrefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs == null) return null;
        String first = strs[0], last = strs[0];
        for (String str : strs) {
            if(str.compareTo(first) < 0) first = str;
            if(str.compareTo(last) > 0) last = str;
        }
        int i =0, len = Math.min(first.length(), last.length());
        while(i < len && first.charAt(i)== last.charAt(i))
            i++;
        return first.substring(0, i);       
    }
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = {"flowers", "flows", "florian"};
        l.longestCommonPrefix(strs);
    }
}