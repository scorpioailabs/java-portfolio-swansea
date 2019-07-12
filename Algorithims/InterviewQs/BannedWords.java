/*package InterviewQs;
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words. 
 It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive. 
The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
/**
 * BannedWords
 */
import java.util.*;
public class BannedWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        int n = banned.length;
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String word : words) {
            if(!ban.contains(word)) {
                count.put(word, count.getOrDefault(word, 0)+1);
            }
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();    
    }
    public static void main(String[] args) {
        BannedWords bw = new BannedWords();
        String paragraph = "a, a, a, a, b,b,b,b,b,c, c";
        String[] banned = {"c"};
        String res = bw.mostCommonWord(paragraph, banned);
        System.out.println(res);
    }
}