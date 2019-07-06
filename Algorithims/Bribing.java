import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Bribing {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int n= q.length;
        int count = 0;
        boolean flag = false;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++) {
                if(q[j]> q[j+1]){
                    if((q[j]-1-j)>2)
                    {
                        flag = true;
                        break;
                    }
                    int temp = q[j];  
                    q[j] = q[j+1];  
                    q[j+1] = temp;
                    count++;
                }
            }
        }
        System.out.println(flag ? "Too chaotic" : count);
    }

    static void somethingBetter(int[]q)
    {
        int count = 0 ;
        
        //always keep track of min three vlaues observed
        //Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree =  Integer.MAX_VALUE;
        int minOfThree =  Integer.MAX_VALUE ;
        
        //iterating from left to right
        for(int i=q.length-1 ; i >= 0 ; i--){
            //person has no way to move more than two positions -> wrong
            if((q[i]-i) > 3 ) {
                System.out.println("Too chaotic");
                return;
            }
            else{
                //means current value has passed at least 3 values -> wrong
                if(q[i] > maxOfThree){
                     System.out.println("Too chaotic");
                     return;
                }
                else if(q[i] > midOfThree){ //means -> current value has bribed 2 ppl
                    count=count+2;
                }
                else if(q[i] > minOfThree){ //means-> current value has bribed 1 person.
                    count=count+1;
                }
                
                //Now adjust minThree values comparing, taking the current vlaue to account
                if(q[i]<minOfThree){
                    maxOfThree=midOfThree;
                    midOfThree=minOfThree;
                    minOfThree = q[i];
                }
                else if(q[i]<midOfThree){
                    maxOfThree=midOfThree;
                    midOfThree = q[i];
                }
                else if(q[i]<maxOfThree){
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);
    }
    

    public static void main(String[] args) {
        int[] q = {1, 2, 3, 4, 5};
        minimumBribes(q);
    }
}
