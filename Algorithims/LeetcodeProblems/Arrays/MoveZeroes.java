/*package LeetcodeProblems.Arrays;
Given an array nums, write a function to move all 0's to the end
 of it while maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
/**
 * MoveZeroes
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int temp =0;
        int zeroes =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroes++;
            }
            else if(zeroes>0) {
                temp = nums[i];
                nums[i] =0;
                nums[i-zeroes] = temp;
            }
        }
    }
    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        m.moveZeroes(nums);
    }
}