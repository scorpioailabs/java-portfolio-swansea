/*package InterviewQs;
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
/**
 * RemoveDuplicates
 */
import java.util.ArrayList;
import java.util.List;
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        if (nums == null || nums.length == 0)
            return n;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        nums[index++] = nums[n - 1];
        return index;
    }
    
    public static int somethingBetter(int[] nums) {
        int n = nums.length;
        if (nums == null || nums.length == 0)
            return n;
        int unique = 0;
        for (int i = 0; i < n; i++) {
            if (nums[unique] != nums[i]) {
                unique++;
                nums[unique] = nums[i];
            }
        }
        return unique + 1;
    }
    public static void main(String[] args) {
        int [] nums = {1, 1, 2, 2, 3, 4, 5, 6, 6};
        int res = removeDuplicates(nums);
    }
}