/*package LeetcodeProblems.Arrays;
Given an array of integers, return indices of the two numbers
 such that they add up to a specific target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
/**
 * TwoSum
 */
import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] out = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                out[1] = i;
                out[0] = map.get(target - nums[i]);
                return out;
            }
            map.put(nums[i], i);
        }
        return out;
    }
}