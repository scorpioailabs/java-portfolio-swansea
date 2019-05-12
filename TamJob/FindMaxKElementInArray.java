public class FindMaxKElementInArray {
    public static void main(String[] args) {
        int[] array = new int[] {4, 10, 3, 5, 1};
 
        int k = 3;
        new FindMaxKElementInArray().printMaxKElements(array, k);
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
    }
 
    public void printMaxKElements(int data[], int k) {
        if(k > data.length) {
            System.out.println("Invalid k size");
            return;
        }
        /*
            {4, 10, 3, 5, 1}
 
                  4
                /  \
               10  3
              / \
             5  1
         */
        //We are taking first k elements {4,10,3} and get the minimum at root that is at data[0]
        for (int i = k - 1; i >= 0; i--) {
            minHeapify(i, data, data.length);
        }
        //At this stage our initial k size array will be {1,4,3,5,10} minimum among first k element is at arr[0]
 
        //this says if say we have only 3 element in array and if k is 3, then {1,4,3} is answer
        //in this case, we have to work for remaining {5,10}, lets see if we can get maximum from them.
 
        //Remember our root is minimum one among first k elements, so while iterating for k+1 till end that is {5,10}
        //if we get maximum element than arr[0], it means arr[0] should be replaced by that value as arr[0] is lowest and
            //we found max than that. After replacing we again want our arr[0] to contain minimum of first K element, so we will again
            //call heapify process for first K element and that will bring minimum back to arr[0] for next comparison.
        //if we get minimum element than arr[0], then we don't care as we are only interested in max elements.
        //At the end, first K elements of array would contain maximum elements of whole array.
 
        //Start from k till end and see if we find element greater than arr[0]
        for (int i = k; i < data.length; i++) {
            if(data[0] < data[i]) {
                //Found some data greater than arr[0], replace that with nex max.
                data[0] = data[i];
 
                //Call heapify process for firsst K elements and that will bring minimum among k elements back to arr[0]
                minHeapify(0, data, k);
            }
        }
 
        //first K elements will have maximum elements of array.
        //Note this first K maximum elements wont be in sorted order, so if require, sort the first K elements.
    }
 
    private int leftChild(int i) {
        return 2 * i + 1;
    }
 
    private int rightChild(int i) {
        return 2 * i + 2;
    }
 
    private void minHeapify(int i, int[] data, int size) {
        int smallestElementIndex = i;
 
        int leftChildIndex = leftChild(i);
        if (leftChildIndex < size && data[leftChildIndex] < data[smallestElementIndex]) {
            smallestElementIndex = leftChildIndex;
        }
 
        int rightChildIndex = rightChild(i);
        if (rightChildIndex < size && data[rightChildIndex] < data[smallestElementIndex]) {
            smallestElementIndex = rightChildIndex;
        }
 
        if (smallestElementIndex != i) {
            int swap = data[i];
            data[i] = data[smallestElementIndex];
            data[smallestElementIndex] = swap;
 
            // Recursively heapify for the affected node
            minHeapify(smallestElementIndex, data, size);
        }
    }
}