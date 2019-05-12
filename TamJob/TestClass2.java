public class TestClass {

	public static int[] buildHeap(int[] arr, int K) {
		int n = arr.length;
		int heapSize = K;
		int[]heapArr = new int[heapSize];
		for (int i =0; i <K; i++) {
			heapArr[i] = arr[i];
			if (heapArr[0] < arr[i]) {
				heapArr = extractMin(heapArr, heapSize);
				heapArr[K-1] = arr[i];
				heapArr = trickleUp(heapArr, i++);
			}
		}
		for (int i = K; i< n; i++) {
			if (heapArr[0] < arr[i]) {
				heapArr = extractMin(heapArr, heapSize);
				heapArr[K-1] = arr[i];
				heapArr = trickleUp(heapArr, i++);
			}
		}
		return heapArr;
	}

	public static int[] extractMin(int[] heapArr, int heapSize) {
		int min = heapArr[0];
		heapArr[0] = heapArr[--heapSize];
		heapArr = minHeapify(heapArr, 0);
		return heapArr;
	}

	public static int[] minHeapify(int[] heapArr, int i) 
	{ 
		// int largest = i; // Initialize largest as root
		int largest = i;
		int temp;
		int n = heapArr.length;
		i = 0;
		int l = 2*i + 1; // left = 2*i + 1 
		int r = 2*i + 2; // right = 2*i + 2
		while (largest < n /2) {
			if (l < n && heapArr[l] > heapArr[i]) {
				largest = l;
			}
			if (r < n && heapArr[r] > heapArr[i]) {
				largest = r;
			}
			if (largest != i) {
				temp = heapArr[i];
				heapArr[i] = heapArr[largest];
				heapArr[largest] = temp;
				i = largest;
				minHeapify(heapArr, largest);
			}
		}
		return heapArr;

	}

	//validated
	public static int[] trickleUp(int[] heapArr, int i) {
		int parent = (i-1) / 2;
		while (i > 0 && heapArr[i] < heapArr[parent]) {
			int temp = heapArr[parent];
			heapArr[parent] = heapArr[i];
			heapArr[i] = temp;
			i = parent;
			parent = (i -1)/2;
		}
		return heapArr;
	}

	//test client
    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		int myArray[] = FastRead.FastReadArray(args[1]);
		int N = myArray.length;
		int[] kNums = buildHeap(myArray, K);
		int i = 0;
		
		Stopwatch st = new Stopwatch();
		
		// ----- Your Code Here -----
		int xorsum = 0;
		// first K numbers of sorted array i.e. the lowest, if the array is in ascending order
		while (i < K) {
			xorsum = xorsum ^ myArray[i];
			i++;
		}
		// end while. set i to now equal the first K number of the largest K numbers in the sorted array. 
		// i = N -K;
		// while (i < N) {
		// 	xorsum = xorsum ^ myArray[i];
		// 	i++;
		// }
		System.out.println(xorsum);
		// ----- Your Code Here -----		
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}

}