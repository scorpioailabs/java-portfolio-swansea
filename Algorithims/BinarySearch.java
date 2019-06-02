// Binary Search : Takes an Integer key, and an (ordered) Integer array of vales as
// arguments and returns the index of the key if present, in array 

public class BinarySearch {
	int mid;
	// Returns index of x if it is present in arr[l...r], else return -1
	public int binarySearch(int [] arr, int l, int r, int x)
	{
		// general case
		if(r >= l) 
		{
			mid = l + (r - l) /2;

			// if the element is present at middle
			if (arr[mid] == x) {
				return mid;
			}
			// if the element is smaller than mid,
			// then it can only be in left subarray
			if (arr[mid] > x) {
				return binarySearch(arr, l, mid -1, x);
			}
			// else the element is in right subarray
			else
				return binarySearch(arr, mid + 1, r, x);
		}

		// if present is not present in array  == base case
		return -1;
	}

	// Driver method
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		QuickSort qsort = new QuickSort();
		int [] arr = {56, 2, 4, 6, 3, 1, 7, 9};
		int n = arr.length;
		//Sort our array
		qsort.quickSort(arr, 0, n-1);
		// Select index we want to search for in array --> any arbitrary number
		int x = 56;
		int result = bs.binarySearch(arr, 0, n-1, x);
		// if not found i.e. if return = -1
		if (result == -1) {
			System.out.println("Element not found in array!");
		}
		else System.out.println("Elemet found at index " + result);
	}
}