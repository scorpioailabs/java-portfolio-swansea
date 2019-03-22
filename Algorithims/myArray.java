public class myArray {
	public myArray() {arr = null; n = 0;};
	
	public myArray(String file) throws Exception {
		arr = FastRead.FastReadArray(file);
		n = arr.length;
	};
	
	public myArray(int[] _arr, int _n) {
		arr = _arr;
		n = _n;
	};
	
	public void print() {
		if (arr != null)
		for (int i=0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	};
	
	public boolean isSorted() {
		for (int i = 0; i < n-1; i++)
			if (arr[i] > arr[i+1])
				return false;
		return true;
	};
	
	public boolean isEqual(myArray b) {
		if (n != b.n) return false;
		for (int i=0; i < n; i++)
			if (arr[i] != b.arr[i])
				return false;
		return true;
	};

	public boolean isSortedUnique() {
		if (!isSorted()) {
			return false;
		} else {
			for (int i=0; i < n-1; i++)
				if (arr[i] == arr[i+1])
					return false;
		} 
		return true;
	};
	
	public void printModulus() {
		// take modulus!
		long modulus = 0;
		for (int i=0;i<n;i++)
			modulus += arr[i];
		System.out.println(""+(modulus % 1000931));
	}
	
	int[] arr;
	int n;
}