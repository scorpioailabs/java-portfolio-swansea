class TestClass {
	//-----Initiliasing the indices leftChild and rightChild in heap-----
	public int leftChild(int i) {
		return 2 * i + 1;
	}
	public int rightChild(int i) {
		return 2 * i + 2;
	}

	//get array of largest K elements from input array
	public int[] kMaxElements(int[] arr, int k) {
		//build minHeap of size k O(k)
		for (int i = k -1; i>=0; i--) {
			minHeapify(arr, i, arr.length);
		}
		//beginning at K, check if i element is grater than arr[0] 
		for(int i = k; i < arr.length; i++) {
			if(arr[0] < arr[i]) {
				//ith element is greater than root, thus replace root with ith element
				int temp;
				temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				//call heapify on the first k elements, which will place smallest K element in K elements at root (i.e. arr[0])
				minHeapify(arr, 0, k);
			}
		}
		//return an output array of K max elements
		int[] output = new int[k];
		for (int i = 0; i < k; i ++) {
			//place first K arr elements in output array
			output[i] = arr[i]; 
		}
		return output;
	}

	//get array of smallest K elements from input array 
	public int[] kMinElements(int[]arr, int k) {
		//build maxHeap of size k O(k)
		for(int i = k -1; i >=0; i--) {
			maxHeapify(arr, i, arr.length);
		}
		//beginning at K, check if i element is smaller than arr[0].
		for(int i = k; i < arr.length; i++) {
			if(arr[i] < arr[0]) { 
				//if current element is smaller than root then replace root with it
				int temp;
				temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				//call heapify on the first k elements, place largest K element in K elements at root
				maxHeapify(arr, 0, k); 
			}
		}
		//return an output array of K max elements
		int[] output = new int[k];
		for (int i = 0; i < k; i ++) {
			//place first K arr elements in output array
			output[i] = arr[i]; 
		}
		return output;
	}

	
	//minHeapify ---> smallest K element goes to root
	// "push-down" "trickledown" "sortdown"
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
			// SWAP			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			
			//Recursively heapify
			minHeapify(arr, minIndex, size); 
		}
	}


	//maxHeapify ---> largest K element goes to root
	// "push-up" "trickleup" "sortup"
	private void maxHeapify(int [] arr, int i, int size) {
		int largestElementIndex = i; 
		int leftChildIndex = leftChild(i);
		int rightChildIndex = rightChild(i);
		if(leftChildIndex < size && arr[leftChildIndex] > arr[largestElementIndex]) {
			largestElementIndex = leftChildIndex;
		}

		if(rightChildIndex < size && arr[rightChildIndex] > arr[largestElementIndex]) {
			largestElementIndex = rightChildIndex;
		}
		if(largestElementIndex != i) {
			//SWAP
			int temp = arr[i];
			arr[i] = arr[largestElementIndex];
			arr[largestElementIndex] = temp;
			//recursively heapify for the affected point
			maxHeapify(arr, largestElementIndex, size);
		}
	}

	//Test Client 
    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		// int myArray[] = FastRead.FastReadArray(args[1]);
		int myArray [] = { 12, 4, 3, 7, 14, 5, 9};
		int N = myArray.length;
		int i = 0;
		
		Stopwatch st = new Stopwatch();
		
		// ---------
		TestClass t = new TestClass();
		//Inputs
		int kMin[] = t.kMinElements(myArray, K); //get K smallest elements in myArray.
		int kMax[] = t.kMaxElements(myArray, K); //get K biggest elements in myArray.
		int xorsum = 0; //initialise xorsum to 0.  ---> sum of XOR operations.
		//iterate through both arrays and calculate xorsum for each element respectively
		// while (i < K) {
		// 	xorsum = xorsum ^ kMin[i] ^ kMax[i];
		// 	i++;
		// }
		// System.out.println(xorsum);
		SortingClient sc = new SortingClient();
		// ----------
		sc.printArray(kMax);
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}
}
