/*package InterviewQs;
Given a string S containing N characters return max number of words in a sentence
/**
 * FnzTaskTwo
 */
public class FnzTaskTwo {
    public int solution(String S) {
        // write your code in Java SE 8
        String[] s = S.split("\\?|\\.|\\!");
        int wordCnt = 0;
        int max = 0;
        for (int i = 0; i < s.length; i++) {
            String temp = s[i];
            String[] words = temp.split(" ");
            for (int j = 0; j < words.length; j++) {
                if (!words[j].isEmpty())
                    wordCnt++;
            }

            if (wordCnt >= max)
                max = wordCnt;
            wordCnt -= wordCnt;
        }
        return max;
    }
    public static void main(String[] args) {
        FnzTaskTwo f = new FnzTaskTwo();
        String s = "Give us a Try. We test coders for real. Yes we do oh.";
        int res = f.solution(s);
        System.out.println(res);
    }
}