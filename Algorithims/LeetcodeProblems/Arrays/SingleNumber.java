/*package LeetcodeProblems.Arrays;
Given a non-empty array of integers, 
every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
Example 1:
Input: [2,2,1]
Output: 1
/**
 * SingleNumber
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums)
            res ^= n;
        return res;
    }
    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        int[] nums = {1,1,2,4,3,4,2,3,5,5,6,10,9,6,10};
        int res = s.singleNumber(nums);
    }
}