/*/**
 * KSortedArray
 * Sort an almost sorted Array:
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2,
 * an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 */
import java.util.PriorityQueue;
public class KSortedArray {
    public void sortKArray(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length;
        //build min heap 
        for (int i = 0; i < k && i < n; i++) {
            minHeap.add(nums[i]);
        }
        int j =0;
        // Place elements into array beginning with minimum element
        for (int i = k; i < n; i++) {
            minHeap.add(nums[i]);
            nums[j] = minHeap.poll();
            j++;
        }
        // Empty out the rest of the heap and place into array
        while(!minHeap.isEmpty()) {
            nums[j] = minHeap.poll();
            j++;
        }
    }
    public static void main(String[] args) {
        KSortedArray ksort = new KSortedArray();
        int[] nums = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        ksort.sortKArray(nums, k);
    }    
}