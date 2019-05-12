public class BinHeap {
	private int[] heapArray;
	private int maxSize;
	private int heapSize;
 
	public BinHeap(int size) {
		heapSize = 0;
		maxSize = size;
		heapArray = new int[maxSize];
	}

	public int kthChild(int i, int  k) {
		return 2*i +k;
	}

	public int leftChild(int i) {
		return 2 * i + 1;
	}
	public int rightChild(int i) {
		return 2 * i + 2;
	}

	// public int maxChild(int i) {
	// 	int leftChild = kthChild(i, 1);
	// 	int rightChild = kthChild(i, 2);
	// 	return heapArray[leftChild]>heapArray[rightChild]?leftChild:rightChild;
	// }
 
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
		heapArray[heapSize++] = key;
		trickleUp(heapSize-1);
	}
 
	// child dominate- parent will be smaller than children, if not then swap
	private void trickleUp(int i) {
		int temp = heapArray[i];
		int parent = (i - 1) / 2;
		while (i > 0 && temp > heapArray[parent]) {
			heapArray[i] = heapArray[parent];
			i = parent;
		}
		heapArray[i] = temp;
	}

/*	private void trickleDown(int i) {
		int child;
		int temp = heapArray[i];
		while (kthChild(i, 1) < heapSize) {
			child = maxChild(i);
			if(temp < heapArray[child]){
				heapArray[i] = heapArray[child];
			}else {
				break;
			}
			i = child;
		}
		heapArray[i] = temp;
	}
*/
	
	private void minHeapify(int [] arr, int i, int size) {
		int minIndex = i;
		int leftChildIndex = leftChild(i);
		int rightChildIndex = rightChild(i);
		if(leftChildIndex < size && arr[leftChildIndex] < arr[minIndex]) {
			minIndex = leftChildIndex;
		}
		if(rightChildIndex < size && arr[rightChildIndex] < arr[minIndex]) {
			minIndex = rightChildIndex;
		}

		if (minIndex != i) {
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			//Recursively heapify
			minHeapify(arr, minIndex, size);
		}
	}

	public int getMax() {
		return heapArray[0];
	}
 
	// To delete element at index x
	public int extract(int x) {
		assert heapSize < 0 : "heap underflow";
		int key = heapArray[x];
		heapArray[x] = heapArray[heapSize-1];
		heapSize--;
		trickleDown(x);
		return key;
	}

	public int getMin() { return heapArray[0]; } // Returns minimum 
}