/*package LeetcodeProblems.Arrays;
Given two arrays, write a function to compute their intersection.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
/**
 * Intersection
 */
import java.util.*;
public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;
        int j = 0;
        int k =0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else j++;
        }
        Integer[] temp = list.toArray(new Integer[list.size()]);
        int[]res = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            res[i] = temp[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Intersection i = new Intersection();
        int[] in1 = {4,9,5};
        int[] in2 = { 9, 4, 9, 8, 4};
        int[] out = i.intersect(in1, in2);        
    }
}