
/*package InterviewQs;
Write a function:

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
/**
 * SmallestPositive
 */
import java.util.*;

public class SmallestPositive {
    public int smallestInt(int[] A) {
        int res = 0;
        List<Integer> set = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        if (set.isEmpty()) {
            return 1;
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        int N = set.size();
        if (res == 0) {
            return set.get(N - 1) + 1;
        } else
            return res;
    }

    //something better
    public int somethingBetter(int[]nums) {
        int i=0, n = nums.length;
        while(i < n) {
            if(nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
            else
                i++;
        }
        int k=1;
        while(k < n && nums[k] == k) {
            k++;
        }
        if(n==0 || k < n)
            return k;
        else
            return nums[0] == k ? k + 1 : k;
    }


    //utility function for swapping
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4 };
        SmallestPositive s = new SmallestPositive();
        int res = s.smallestInt(A);
        System.out.println(res);
    }
}