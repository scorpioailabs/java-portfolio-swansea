    // Complete the oddNumbers function below.
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
    
public class HackerRank {
    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> arr = new ArrayList<>();
        //size of array
        int n = r+1-l;
        int[] tempArr = new int[n];
        int j=0;
        for(int i =l; i<=r; i++)
        {
           tempArr[j] = i;
           j++;
        }
        for(int i=0; i<n; i++)
        {
           if(tempArr[i]%2 == 1)
              arr.add(tempArr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
    	int l = Integer.parseInt(args[0]);
    	int r = Integer.parseInt(args[1]);
    	List<Integer> res = oddNumbers(l, r);
    	for (int i=0;i<res.size();i++) {
    		System.out.println(res.get(i));
    	}
    }
}
