public class BinHeap {
	private int[] heapArray;
	private int maxSize;
	private int heapSize;
 
	public BinHeap(int size) {
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
}