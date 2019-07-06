//quick sort
public class QuickSort {
	/* This function takes the last element as pivot, and places
		the pivot element at its correct position in sorted array. 
	*/
	/* The main function that implements QuickSort() 
	   arr[] --> Array to be sorted, 
	   low  --> Starting index, 
	   high  --> Ending index */
	public void quickSort(int arr[], int low, int high) {
		//base case
		if(high<=low || low>=high){}
		else
	    {
	    	int pivot = arr[low];
	    	int i = low+1; int temp;
	    	// parition array
	    	for (int j=low + 1; j<=high; j++) 
	    	{ 
	    	    // If current element is smaller than or 
	    	    // equal to pivot 
	    	    if (pivot > arr[j]) 
	    	    { 	    	
	    	        // swap arr[i] and arr[j] 
	    	        temp = arr[j]; 
	    	        arr[j] = arr[i]; 
	    	        arr[i] = temp;
	    	        i++;  
	    	    } 
	    	}
	    	arr[low] = arr[i-1];
	    	arr[i-1] = pivot;
	         // Recursively sort elements on left and right sides
	        quickSort(arr, low, i-2); 
	        quickSort(arr, i, high); 
	    } 
	}

}