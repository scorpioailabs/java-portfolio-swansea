// ----- Your Code Here, if need to -----
// public class XXX
// ...
// ----- Your Code Here, if need to -----

class XORSumArray {
	// ----- Your Code Here, if need to -----


	public static int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = l; i<n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	

	public static int[] InsertionSort(int [] arr) {
		int n = arr.length; //length of my unsorted array
 		for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key;
        }
        return arr;
	}

	// ...
	// ...
	// ----- Your Code Here, if need to -----

    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		int myArray[] = new int [] { 4, 2, 7, 1, 3};
		int[] sorted = InsertionSort(myArray);
		int N = myArray.length;
		int i = 0;		
		// Stopwatch st = new Stopwatch();
		
		// ----- Your Code Here -----
		// ...
		int xorsum = 0;
		//first K numbers of sorted array i.e. the lowest, if the array is in ascending order
		while (i < K) {
			xorsum = xorsum ^ myArray[i];
			i++;
		}
		//end while. set i to now equal the first K number of the largest K numbers in the sorted array. 
		i = N -K;
		while (i < N) {
			xorsum = xorsum ^ myArray[i];
			i++;
		}

		System.out.println(xorsum);
		// ----- Your Code Here -----		
		// double time = st.elapsedTime();
		// System.err.println("Elapsed Time: "+time+" s");			
	}
}
