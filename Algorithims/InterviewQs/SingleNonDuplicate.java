/*package InterviewQs;
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
/**
 * SingleNonDuplicate
 */
import java.util.*;
public class SingleNonDuplicate {
    public int singleNumber(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.remove(nums[i]);   
            }
            else
                map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
            {
                res.add(nums[i]);
            }
        }
        return res.get(0);
    }

    //Use bitwise operator XOR
    public int somethingBetter(int[]nums) {
        int res = 0;
        for (int n : nums)
            res ^= n;
        return res;
    }
    public static void main(String[] args) {
        SingleNonDuplicate s = new SingleNonDuplicate();
        int[] in = {3,6,10,2,1,6,1,2,3};
        int res = s.singleNumber(in);
        System.out.println(res);
        System.out.println("Something faster: ");
        int res2 = s.somethingBetter(in);
        System.out.println(res2);
    }
}