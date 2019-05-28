//Sorting algorithms
public class SortingClient {
	public void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String args[] ) throws Exception {
		SortingClient sc = new SortingClient();
		InsertionSort isort = new InsertionSort();
		BubbleSort bsort = new BubbleSort();
		MergeSort msort = new MergeSort();
		QuickSort qsort = new QuickSort();
		int [] arr = FastRead.FastReadArray(args[0]);
		int n = arr.length;
		Stopwatch st = new Stopwatch();
		double time;
		/*-------------------------------------------------------------------/
		System.out.println("Insertion Sort: ");
		isort.insertionSort(arr);
		double time1 = st.elapsedTime();
		// sc.printArray(arr);
		System.err.println("Elapsed Time: "+time1+" s");
		/*--------------------------------------------------------------------*/
		System.out.println("Quick Sort: ");
		int [] arr2 = FastRead.FastReadArray(args[0]);
		qsort.quickSort(arr2, 0, n-1);
		double time2 = st.elapsedTime();
		// sc.printArray(arr1);
		System.err.println("Elapsed Time: "+time2+" s");
		/*--------------------------------------------------------------------*/
		System.out.println("Merge Sort: ");
		int [] arr1 = FastRead.FastReadArray(args[0]);
		msort.mergeSort(arr1, 0, n-1);
		double time3 = st.elapsedTime() - time2;
		// sc.printArray(arr2);
		System.err.println("Elapsed Time: "+time3+" s");
		/*--------------------------------------------------------------------/
		System.out.println("Bubble Sort: ");
		int [] arr3 = FastRead.FastReadArray(args[0]);
		bsort.bubbleSort(arr3);
		double time4 = st.elapsedTime() - (time1 + time2 + time3);
		// sc.printArray(arr3);
		System.err.println("Elapsed Time: "+time4+" s");
		/*--------------------------------------------------------------------*/
	}	
}