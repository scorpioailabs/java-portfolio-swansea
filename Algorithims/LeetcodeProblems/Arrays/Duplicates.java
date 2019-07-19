/*package LeetcodeProblems.Arrays;
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.
Example 1:
Input: [1,2,3,1]
Output: true
/**
 * Duplicates
 */
import java.util.*;
public class Duplicates {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        
    }
}