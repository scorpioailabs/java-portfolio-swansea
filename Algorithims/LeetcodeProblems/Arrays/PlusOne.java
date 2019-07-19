/*package LeetcodeProblems.Arrays;
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list,
 and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.
Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
/**
 * PlusOne
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] == 10)
                digits[i] = 0;
            else
                return digits;
        }
        //if the last digit happened to be 9 then we get here
        // othewise this statement won't be reached
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {9};
        PlusOne p = new PlusOne();
        p.plusOne(nums);
    }
}