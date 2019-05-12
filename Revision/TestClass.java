public class TestClass {
	//paritition process of quicksort
	//last element x = pivot
	// move all smaller element to left of it and 
	// greater elements to right of it
	public static int[] kMax(int arr[], int K) {
		int min = 0;
		int n = arr.length;
		// x = pivot
		for (int i = K; i < n; i++) {
			for (int j =0; j < K; j++) {
				if(arr[j] < arr[min]) {
				//set element 0 to value of arr[j]
					min = j;
				}
				if (arr[min] < arr[i]) {
					int temp = arr[min];
					arr[min] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] kMin(int arr[], int K) {
		int n = arr.length;
		int max = arr[n - 1];
		for(int i = K; i < n; i++) {
			for (int j = 0; j < K; j++) {
				if(arr[j] > arr[max]) {
					max = j;
				}
				if (arr[max] > arr[i]) {
					int temp = arr[max];
					arr[max] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

	//test client
    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		int myArray[] = FastRead.FastReadArray(args[1]);
		// int N = myArray.length;
		int i = 0;
		// int myArray[] = {4, 2, 7, 1, 3};
		int N = myArray.length;
		int xorsum =0;
		i = 0;
		int[] min = kMin(myArray, K);
		while (i < K) {
			xorsum = xorsum ^ min[i];
			i++;
		}
		int[] max = kMax(myArray, K);
		i = 0;
		while (i < K) {
			xorsum = xorsum ^ max[i];
			i++;
		}
		Stopwatch st = new Stopwatch();
		
		// ----- Your Code Here -----
		// first K numbers of sorted array i.e. the lowest, if the array is in ascending order
		//end while. set i to now equal the first K number of the largest K numbers in the sorted array. 

		System.out.println(xorsum);
		// ----- Your Code Here -----		
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}


}