public class Mergesort {
    //private implementation, merge sub arrays
    public void merge(int[]a, int l, int m, int r)
    {
        // create two sub arrays
        int n1 = m - l + 1;
        int n2 = r - m;
        int left[] = new int [n1];
        int right[] = new int [n2];
        //build up both sub arrays
        for (int i = 0; i < n1; i++) {
            left[i] = a[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = a[m + 1 + i];
        }
        //merge the temp arrays
        int i =0, j = 0, k = l;
        while (i < n1 && j < n2)
        {
            if(left[i]<=right[j]){
                a[k] = left[i];
                i++;
            }
            else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        //copy remaining elements 
        while(i < n1)
        {
            a[k] = left[i];
            i++;
            k++;
        }
        while(j< n2)
        {
            a[k] = right[j];
            j++;
            k++;
        }
    }
    private void mergeSort(int[]a, int l, int r)
    {
        if(l<r) 
        {
            //establish the middle point
            int m = (l+r)/2;
            //sort first half
            mergeSort(a, l, m);
            //sort second half
            mergeSort(a, m+1, r);
            //call merge on the sorted halves
            merge(a, l, m, r);
        }
    }
    public static void main(String[] args) {
        int[] a = {100,285,412,324,432,564,21,7,88,8,56,48,7455,78548,7588,2331,24,4,480};
        int n = a.length;
        Mergesort mSort = new Mergesort();
        mSort.mergeSort(a, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);            
        }
    }
}