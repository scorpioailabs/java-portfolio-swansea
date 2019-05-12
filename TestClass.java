import java.io.*; 
import java.util.*; 
public class TestClass {

	public static int getMax(int arr[], int n) {
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx;		
	}

	public	static int getMin(int arr[], int n) {
		int mn = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] < mn) 
                mn = arr[i]; 
        return mn;	
	}

	public static int[] countSort(int arr[], int n, int exp, int min) {
		int bucketIndex;
		int[] buckets = new int[10];
		int[] output = new int [n]; 

		//Initialize bucket
		for(int i =0; i < 0; i++) {
			buckets[i] = 0;
		}
  
        // Store count of occurrences in buckets[]
        for (int i = 0; i < n; i++) {
            bucketIndex	= (int)(((arr[i] - min) / exp) % 10);
            buckets[bucketIndex]++;
        }

        //count cumulates 
        for (int i = 1; i < 10; i++) 
            buckets[i] += buckets[i - 1]; 
  
        // Build the output array 
        for (int i = n - 1; i >= 0; i--) 
        { 
        	bucketIndex	= (int)(((arr[i] - min)/ exp) % 10);
        	output[--buckets[bucketIndex]] = arr[i];
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (int i = 0; i < n; i++){
            arr[i] = output[i];
        }
        return arr;
	}

	public static int[] radixsort(int arr[], int n){
		int max = getMax(arr, n);
		int min = getMin(arr, n);

		
		int exp = 1;
		while((max - min) / exp >= 1) {
			countSort(arr, n, exp, min);
			exp *= 10;
		}
		return arr;
	}

		//test client
    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		int myArray[] = FastRead.FastReadArray(args[1]);
		int N = myArray.length;
		int[] sorted = radixsort(myArray, N);
		int i = 0;
		
		Stopwatch st = new Stopwatch();
		
		// ----- Your Code Here -----
		int xorsum = 0;
		// first K numbers of sorted array i.e. the lowest, if the array is in ascending order
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
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}

}