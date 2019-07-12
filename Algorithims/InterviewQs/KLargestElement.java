import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that this is the kth largest element in the sorted order,
not the kth distinct element.
Example
Input: [3,2,1,5,6,4] and K = 2
Output: 5
Tip DON'T SORT!
*/
public class KLargestElement {

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public int findKthLargest(int[]nums, int k) {
        //BUILD UP min HEAP of Size K
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i : nums) {
            minHeap.add(i);
            if(minHeap.size()>k)
            {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
    public int somethingBetter(int[]nums, int k) {
        //Build up min heap of size k
        for (int i = k - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[0]<nums[i])
            {
                //replace root with ith element
                int temp;
                temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
                // call heapify on the first k elements, which will place smallest K element in
                // K elements at root (i.e. arr[0])
                heapify(nums, 0, k);
            }                      
        }
        return nums[0];
    }

    // heapify ---> smallest K element goes to root
    private void heapify(int[] arr, int i, int size) {
        int minIndex = i;
        int leftChildIndex = leftChild(i);
        int rightChildIndex = rightChild(i);
        if (leftChildIndex < size && arr[leftChildIndex] < arr[minIndex]) {
            minIndex = leftChildIndex;
        }
        if (rightChildIndex < size && arr[rightChildIndex] < arr[minIndex]) {
            minIndex = rightChildIndex;
        }
        if (minIndex != i) {
            // SWAP
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            // Recursively heapify
            heapify(arr, minIndex, size);
        }
    }
    public static void main(String[] args) {
        KLargestElement test = new KLargestElement();
        Stopwatch st = new Stopwatch();
        int k = Integer.parseInt(args[0]);
        int[] in = {3,2,5,1,6,4,5,4,4,2,1,988,44,41,4,2,45,45,47,4,5,4,44,55,4,8,8,4,8,841,58,5,4,88,4,8};
        int res = test.findKthLargest(in, k);
        System.out.println("Kth Largest element: " + res);
        double time2 = st.elapsedTime();
        System.err.println("Elapsed Time: " + time2 + " s");
        int res2 = test.somethingBetter(in, k);
        System.out.println("And using my own heap implementation. The Kth Largest element : " + res2);
        double time = st.elapsedTime();
        System.err.println("Elapsed Time: " + time + " s");
    }
}