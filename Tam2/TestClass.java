public class TestClass {
	private int[] heapArray;
	private int maxSize;
	private int heapSize;
 
	public TestClass(int size) {
		heapSize = 0;
		maxSize = size;
		heapArray = new int[maxSize];
	}
 
	public int size() {
		return heapSize;
	}
 
	public int peek() {
		assert heapSize <= 0 : "heap underflow";
		return heapArray[0];
	}
 
	public int get(int i) {
		assert heapSize <= 0 : "heap underflow";
		return heapArray[i];
	}
 
	public void insertKey(int key) {
		assert heapSize > maxSize - 1 : "heap overflow";
		heapArray[heapSize] = key;
		trickleUp(heapSize++);
	}
 
	// child dominate- parent will be smaller than children, if not then swap
	private void trickleUp(int i) {
		int parent = (i - 1) / 2;
		while (i > 0 && heapArray[i] < heapArray[parent]) {
			int temp = heapArray[parent];
			heapArray[parent] = heapArray[i];
			heapArray[i] = temp;
			i = parent;
			parent = (i - 1) / 2;
		}
	}
 
	// Top will be always the minimum
	public int extractMin() {
		assert heapSize < 0 : "heap underflow";
		int min = heapArray[0];
		heapArray[0] = heapArray[--heapSize];
		minHeapify(0);
		return min;
	}
   
   public int extractMax() {
      int max = heapArray[1];
      heapArray[1] = heapArray[--heapSize];
      minHeapify(1);
      return max;
   }
 
	// Parent is less than its children
	public void minHeapify(int i) {
		int smallest = i;
		while (smallest < heapSize / 2) {
			int left = (2 * i) + 1;
			int right = left + 1;
			if (left < heapSize && heapArray[left] < heapArray[i]) {
				smallest = left;
			}
			if (right < heapSize && heapArray[right] < heapArray[smallest]) {
				smallest = right;
			}
			if (smallest != i) {
				int temp = heapArray[i];
				heapArray[i] = heapArray[smallest];
				heapArray[smallest] = temp;
				i = smallest;
			} else {
				break;
			}
		}
	}
   public static int[] kMax(int[] input, int k) {
		// if required number of largest items is less than the given
		// array, return array itself
		if (input.length <= k) {
			return input;
		}
		int[] output = new int[k];
		TestClass minHeap = new TestClass(input.length);
		// insert the array's K element to the minHeap
		for (int i = 0; i < input.length; i++) {
			if (minHeap.size() < k) {
				minHeap.insertKey(input[i]);
			} else {
				if (minHeap.peek() < input[i]) {
					minHeap.extractMin();
					minHeap.insertKey(input[i]);
				}
			}
		}
		// Heap contains top K maximum numbers
		for (int i = 0; i < minHeap.size(); i++) {
			output[i] = minHeap.get(i);
		}
		return output;
	}
   
   	public static int[] kMin(int[] input, int k) {
		// if required number of smallest items is less than the given
		// array, return array itself
		if (input.length <= k) {
			return input;
		}
		int[] output = new int[k];
		TestClass minHeap = new TestClass(k);
		// insert the array's K element to the minHeap
		for (int i = 0; i < input.length; i++) {
			if (minHeap.size() < k) {
				minHeap.insertKey(input[i]);
			} else {
				if (minHeap.peek() > input[i]) {
					minHeap.extractMax();
					minHeap.insertKey(input[i]);
				}
			}
		}
		// Heap contains top K maximum numbers
		for (int i = 0; i < minHeap.size(); i++) {
			output[i] = minHeap.get(i);
		}
		return output;

	}


	//test client
    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		int myArray[] = FastRead.FastReadArray(args[1]);
		int N = myArray.length;
		int[] kNums = kMax(myArray, K);
		int[] kminNums = kMin(myArray, K);
		int i = 0;
		
		Stopwatch st = new Stopwatch();
		
		// ----- Your Code Here -----
		int xorsum = 0;
		// first K numbers of sorted array i.e. the lowest, if the array is in ascending order
		while (i < K) {
			xorsum = xorsum ^ kNums[i] ^ kminNums[i];
			i++;
		}
		System.out.println(xorsum);
		// ----- Your Code Here -----		
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}
}