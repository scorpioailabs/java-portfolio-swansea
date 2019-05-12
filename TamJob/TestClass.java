//COMPLYINGGGG
public class TestClass {

	public int leftChild(int i) {
		return 2 * i + 1;
	}
	public int rightChild(int i) {
		return 2 * i + 2;
	}

	//testing
	public int[] kMaxElements(int[] arr, int k) {
		//build minHeap of size K
		for (int i = k -1; i>=0; i--) {
			minHeapify(arr, i, arr.length);
		}
		//beginning at K, check if i element is grater than arr[0]
		for(int i = k; i < arr.length; i++) {
			if(arr[0] < arr[i]) {
				//ith element is greater than root, thus replace root with ith element
				arr[0] = arr[i];
				//call heapify on the first k elements, which will place min K element in K elements at root (i.e. arr[0])
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

	//works
	public int[] kMinElements(int[]arr, int k) {
		//build maxHeap of size K
		for(int i = k -1; i >=0; i--) {
			maxHeapify(arr, i, arr.length);
		}
		//beginning at K, check if i element is smaller than arr[0]... root (arr[0]) must contain smallest number
		for(int i = k; i < arr.length; i++) {
			if(arr[i] < arr[0]) { 
				//if current element is larger than root then replace it
				arr[0] = arr[i];
				//call heapify on the first k elements, place max K element in K elements at root
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

	
	//minHeapify ---> smallest element goes to root ---> WORKS!!
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


	//maxHeapify ---> largest element goes to root ---> WORKS!!
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


    private void printArray(int[]arr, int Kth) {
    	for (int i = 0; i < Kth; i++) {
    		System.out.println(arr[i]);
    	}
    }


	//test client
    public static void main(String args[] ) throws Exception {
		TestClass t = new TestClass();
		int K = Integer.parseInt(args[0]);
		int myArray[] = FastRead.FastReadArray(args[1]);
		// int myArray[] = {4, 21, 3, 8, 9, 10, 2, 5, 1};
		int kMax[] = t.kMaxElements(myArray, K);
		System.out.println("The K largest elements are: ");
		t.printArray(kMax, K);
		myArray = FastRead.FastReadArray(args[1]);
		int kMin[] = t.kMinElements(myArray, K);
		int i = 0;
		Stopwatch st = new Stopwatch();

		// TESTING
		System.out.println("The K smallest elements are: ");
		t.printArray(kMin, K);
		// System.out.println("Xorsum of these K elements is: ");
		

		int xorsum = 0;
		while (i < K) {
			xorsum = xorsum ^ kMin[i] ^ kMax[i];
			i++;
		}
		System.out.println(xorsum);
		// ----- Your Code Here -----		
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}

}