package diskScheduling;
import java.util.*;
public class SCAN {

    public static int  callSCAN(int arr[],int init,int maxreq){
        /* In this algorithm head moves only in one direction and
         *  on reaching the boundary its reverses its direction 
         *  Here in this algorithm , we implement it move in forward direction first
         *  ,i.e towards higher track requests,then towards lower track request*/

        int sum=0,len=arr.length;

        //sorting the requests
        Arrays.sort(arr);

        //finding virtual location of init in the request array
        //binary search returns the index of search element if found 
        //else it returns -(insertion point) -1
        int pos=    Arrays.binarySearch(arr, init);

        pos=-pos-1;
//      System.out.println(pos);
        int left=pos-1,right=pos;

        //moving towards right side first in the array
        sum+=Math.abs(init-arr[right]);
        System.out.println(arr[right]);
        while(right<len-1){
            sum+=Math.abs(arr[right]-arr[right+1]);
            System.out.println(arr[right+1]);
            right++;
        }
        /* moving to maximum possible track request from
         *  where head will reverse its direction  */
        sum+=Math.abs(arr[len-1]-maxreq);
        System.out.println(maxreq);


        //now moving towards left direction .
        sum+=Math.abs(maxreq-arr[left]);
        System.out.println(arr[left]);

        while(left!=0){
            sum+=Math.abs(arr[left]-arr[left-1]);
            System.out.println( arr[left-1]);
            left--;
        }
        return sum;
    }
    public static void main(String[] args) {
        //maxreq maximum possible disk request
        int maxreq = 80;
        //request array
        int arr[]={24, 38, 17, 2, 19, 80, 48, 8};
        // disk head starts at init
        int init=12;
        int res=callSCAN(arr,init,maxreq);
        System.out.println("Total Head Movement= "+res);
    }

}