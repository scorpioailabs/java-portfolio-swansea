/*package LeetcodeProblems.Strings;
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
/**
 * ImplementstrStr
 */
public class ImplementstrStr {
    //KMP Knuth-Morris-Pattern Algorithm
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0 || haystack.equals(needle)) return 0;
        int[]table = searchStr(needle, m);
        int i =0, j = 0;
        while(i < n && j < m){
            //if there's a match
            if(haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
            } else {
                if(j!=0) j = table[j-1];
                else i++;
            }
        }
        if(j == m) return i-m;
        else return -1;
    }
    // build table of prefix and suffix
    private int[] searchStr(String needle, int m) {
        int[] table = new int[m];
        int index = 0;
        for (int i = 1; i < m;) {
            if(needle.charAt(i) == (needle.charAt(index))){
                table[i] = index + 1;
                index++;
                i++;
            } else {
                if(index!= 0) index = table[index-1];
                else{ table[i] = 0; i++; }
            }
        }
        return table;
    }

    //OPTIMISED BRUTE-FORCE APPROACH 
    public int somethingBetter(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int i =0, j =0;
        if (m == 0 || haystack.equals(needle)) return 0;
        while(i<=n-m){
            for(j=0; j < m; ++j) {
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
                if(j==m-1) return i;
            }
            ++i;
        }
        return -1;
    }
    
    //LAZY APPROACH IF UTILS ARE ALLOWED
    public int lazy(String haystack, String needle) {
        if(haystack==null) return -1;
        return haystack.indexOf(needle);
    }
    //bruteforce apprach too slow --> O(n*m)
    public int bruteForce(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int i =0;
        if(haystack.equals(needle)) return 0;
        for (i = 0; i < haystack.length(); i++) {
            for (int j = i + 1; j <= haystack.length(); j++) {
                if (haystack.substring(i, j).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }   


    public static void main(String[] args) {
        ImplementstrStr i = new ImplementstrStr();
        String haystack = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String needle = "aaaaaaaaaa";
    }
}