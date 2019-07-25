
/*package LeetcodeProblems.Strings;
Given a string, find the first non-repeating character in it 
and return it's index. If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
/**
 * FirstUniqueChar
 */
import java.util.*;
public class FirstUniqueChar {
    // 2-pass solution
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(freq[c - 'a'] == 1)
                return i;
        }
        return -1;
    }    
    
    // 1-pass solution
    public int somethingDifferent(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            }
            else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}