// Heap using Binary Heap using Array Implementation
public class Heap {
	//-----Initiliasing the indices leftChild and rightChild in heap-----
	private int n;
	public int leftChild(int i) {
		return 2 * i + 1;
	}
	public int rightChild(int i) {
		return 2 * i + 2;
	}
	// private int arr[]; // The heap array
	private int size(int [] arr) 
	{
		return arr.length; // Number of elements in heap
	}
	/**
	* runs at O(size)
	*/
	private void buildHeap(int [] arr)
	{
		for(int k= size(arr)-1; k >=0; k--)
		{
			// recursively arrify
			pushdown(arr, k, size(arr));
		}
	}
	/**
	* pushdown ---> smallest K element goes to root
	* "push-down" "trickledown" "sortdown"
	* runs at O(log k)
	*/
	private void pushdown(int [] arr, int i, int size) 
	{
		int minIndex = i;
		int lCI = leftChild(i);
		int rCI = rightChild(i);
		if(lCI < size && arr[lCI] < arr[minIndex]) {
			minIndex = lCI;
		}
		if(rCI < size && arr[rCI] < arr[minIndex]) {
			minIndex = rCI;
		}

		if (minIndex != i) {
			// SWAP			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			
			//Recursively heapify
			pushdown(arr, minIndex, size); 
		}
	}
	//Ascending order
	public void heapSort(int [] arr) 
	{
		int n = arr.length;
		//build heap
		// Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
		    pushup(arr, i, n);

		// One by one extract an element from heap
		for (int i=n-1; i>=0; i--)
		{
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			//recursively call push up
			pushup(arr, 0, i);
		}
	}
	/**
	* pushup ---> largest K element goes to root
	* "push-up" "trickleup" "sortup"
	* runs at O(log k)
	*/
	private void pushup(int [] arr, int i, int size) 
	{
		int maxIndex = i; 
		int lCI = leftChild(i);
		int rCI = rightChild(i);
		if(lCI < size && arr[lCI] > arr[maxIndex]) {
			maxIndex = lCI;
		}

		if(rCI < size && arr[rCI] > arr[maxIndex]) {
			maxIndex = rCI;
		}
		if(maxIndex != i) {
			//SWAP
			int temp = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = temp;
			//recursively heapify for the affected point
			pushup(arr, maxIndex, size);
		}
	}

	public int removeMin(int[] arr) {
		int N = arr.length;
		for(int k= size(arr)-1; k >=0; k--)
		{
			// recursively arrify
			pushdown(arr, k, size(arr));
		}
		int temp = arr[0];
		arr[0] = arr[1];
		N--;
		return temp;
	}

	public int removeMax(int[] arr) {
		int N = arr.length;
		for(int k= size(arr)-1; k >=0; k--)
		{
			// recursively arrify
			pushup(arr, k, size(arr));
		}
		int temp = arr[0];
		arr[0] = arr[1];
		N--;
		return temp;
	}

	// Main Client

	public static void main(String[] args) throws Exception{
		Heap h = new Heap();
		int arr[] = { 12, 4, 3, 7, 14, 5, 9};
		h.heapSort(arr);
		SortingClient sc = new SortingClient();
		sc.printArray(arr);
		System.out.println("Minimum element: " + h.removeMin(arr));
		sc.printArray(arr);
	}

}