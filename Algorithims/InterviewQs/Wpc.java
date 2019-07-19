/*package InterviewQs;

/**
 * Wpc
 */
import java.util.*;
public class Wpc {
    /// <summary>
    /// Returns whether or not the value is contained in the array
    /// </summary>
    public static boolean ArrayContainsValue(int[] array, int value)
    {
      int n = array.length;
      if(n==0 || value ==0)
        return false;
      for (int i = 0; i < n; i++) {
          if(array[i]==value) {
              return true;
          }
      }
      return false;
    }

    /// <summary>
    /// Returns an array of unique integers that are contained in all three arrays.
    /// </summary>
    public static int[] CommonNumbersInArrays(int[] array1, int[] array2, int[] array3) {
        if(array1== null || array2== null|| array3== null) {
            int arr[] = new int [0];
            return arr;
        }
        Set<Integer> h = new HashSet<Integer>();
        int n = array1.length;
        int m = array2.length;
        int o = array3.length;
        Arrays.sort(array1);
        Arrays.sort(array2);
        Arrays.sort(array3);
        int i=0, j=0, k=0, l=0;
        while (i < n && j < m && k < o)  {
            if(array1[i] == array2[j] && array2[j] == array3[k]) {
                h.add(array1[i]);
                i++; j++; k++; l++; 
            }
            else if(array1[i] < array2[j] && array1[i] < array3[k]) {
                i++;
            }
            else if(array2[j] < array1[i] && array2[j] < array3[k]) {
                j++;
            }
            else k++;
        }
        int size = h.size();
        int[] res = new int[size];
        Integer[] temp = h.toArray(new Integer[h.size()]);
        int c =0;
        for (i = 0; i < size; i++) {
            res[i] = temp[i];
        }
        return res;        
        throw new UnsupportedOperationException();
    }

    /// <summary>
    /// Returns whether or not the passed in word is a palindrome if all punctuation
    /// is excluded
    /// </summary>
    /// <remarks>A palindrome reads the same forward or reversed</remarks>
    public static boolean SentenceIsPalindrome(String word) {
        String str = word.replaceAll("\\s|[^a-zA-Z0-9]", "").toLowerCase();
        if (word == null || word.equals("")) {
            return false;
        }
        if (str == null || str.equals("")) {
            return false;
        }
        // create an empty stack of characters
        Stack chars = new Stack();

        // push every character of the given string into the stack
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); ++i) {
            chars.push(ch[i]);
        }

        // start from index 0
        int k = 0;

        // pop charcters from the stack until it is empty
        while (!chars.isEmpty()) {
            // assign each popped char back to char array
            ch[k++] = (Character) chars.pop();
        }

        // convert the character array into string and return it
        String res = String.copyValueOf(ch);
        if (res.equals(str)) {
            return true;
        }
        return false;
    }

    /// <summary>
    /// Returns the nth number in the sequence if the first 5 numbers in the
    /// sequence are 1, 1, 2, 3, 5, where n is the index passed into this method
    /// </summary>
    /// <remarks>By definition, the first two numbers in this sequence are 1 and 1,
    /// and each subsequent number is the sum of the previous two.</remarks>
    public static int NumericalSequence(int n) {
        if(n < 0)
            throw new IllegalArgumentException("Invalid input");
        // conditions
        if (n == 1 || n == 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        // we know first two numbers in fib sequence to be 1 so:
        arr[1] = 1;
        arr[2] = 1;
        // for the rest of array from index 3 onwards:
        for (int i = 3; i < n + 1; ++i) {
            arr[i] = arr[i - 1] + (arr[i - 2]);
        }
        // got to end now return the nth element in the array
        return arr[n];
    }

    /// <summary>
    /// Returns the smallest angle between the hands of an analog clock for the
    /// given time.
    /// </summary>
    public static double AngleBetweenHands(int hours, int minutes) {
        if(hours < 0 || minutes< 0 || hours> 12 || minutes> 60) {
            throw new IllegalArgumentException("Invalid time");
        }
        double angleOfHour = 0.5 * (hours*60+minutes);
        double angleOfMin = 6*minutes; 
        double angle = Math.abs(angleOfHour - angleOfMin);
        angle = Math.min(360-angle, angle);
        return angle;
    }    
}