//MergeSort
public class MergeSort {
	//merge two sub arrays of arr[]
	public void merge(int[] arr, int l, int m, int r) {
		// Find sizes of two sub arrays to be merges
		int n1 = m - l + 1;
		int n2 = r - m;
		// create temp arrays
		int left [] = new int [n1];
		int right [] = new int [n2];
		// copy data to temp arrays
		for (int i =0; i <n1; ++i) {
			left[i] = arr[l + i];
		}
		for (int i =0; i < n2; ++i) {
			right[i] = arr[m + 1 + i];
		}
		// merge the temp arrays
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right [j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		// copy remaining elements
		// from left []
		while(i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		// from right []
		while(j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	// Main function that sorts arr[l..r] using 
	// merge() 
	public void mergeSort(int arr[], int l, int r) 
	{ 
	    if (l < r) 
	    { 
	        // Find the middle point 
	        int m = (l+r)/2; 
	
	        // Sort first and second halves 
	        mergeSort(arr, l, m); 
	        mergeSort(arr , m+1, r); 
	
	        // Merge the sorted halves 
	        merge(arr, l, m, r); 
	    } 
	}
}