//Selection sort
public class SelectionSort {
	public static int [] SelectionSort(int [] arr) {
		int n = arr.length;
		for (int i =0; i < n; i++) {
			int minptr = i;
			for (int j = i+1; j<n; j++) {
				if (arr[j] < arr[minptr]) {
					minptr = j;
				}
			}
			int temp = arr[minptr];
			arr[minptr] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static void main(String[] args) {
		int a [] = { 2, 5, 11, 3, 9, 1};
		SelectionSort(a);
		for (int i =0; i < a.length; i++){
			System.out.println(a[i]);
		}

	}
}