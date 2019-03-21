public class complexity {
	void merge(int arrA[], int arrB[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }

    public static myArray intersect(int arr1[], int arr2[], int n, int m) {
    	int [] a = a.arr; n = a.n;
    	int [] b = b.arr; m = b.m;
    	int i = 0;
    	int j =0;
    	while(i < n && j < m) {
    		if()
    	}
    }

    public static void main(String[] args) {
		int [] A = {2, 10, 17, 33, 34, 41};
      	int [] B = {9, 10, 13, 16, 22, 32};
		int n = A.length;
		int m = B.length;

		merge(A, B);

		System.out.println("A : " + A);
		System.out.println("B : " + B);
   }
}