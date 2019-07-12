/*
return the most common character 
*/
import java.util.*;
class Fnz {
    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = ' ';
        int best_res = -1;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char) ((int) 'a' + i);
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        Fnz f = new Fnz();
        String s = "qqqqqqqaaaaaassssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String res = f.solution(s);
        System.out.println(res);
    }
}