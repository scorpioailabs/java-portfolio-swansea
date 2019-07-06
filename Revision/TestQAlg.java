/*
** This function calculates the maximum of the multiplication of 
*  the three highest values in an array.
*
*/



public class TestQAlg {
	public static int something (int arr[]) {
	int N = arr.length;
	int tmp = -1;
   	int max = 0;
	for (int i=0; i < N-2; i++) {
		for (int j= 0; j < i-2; j++) {
			//C1: O(n2)
			max = arr[i] * arr[j] * arr[j+1];
		}
		tmp = arr[i]*arr[i+1]*arr[i+2];
		if (tmp > max);
		max = tmp;
		}
      return max;
	}

	public static void somethingnewer(int A[], int B)
	{
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i!=j) && (A[i] + A[j] == B)) {
					System.out.println("("+i+","+j+")");
					return;
				}
			}
		}
		System.out.println("(-1,-1)");
	}

	public static void somethingBetter(int A[], int B)
	{
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (A[i] + A[i+1] == B)
				System.out.println("("+A[i]+","+A[i+1]+")");
		}
		System.out.println("(-1,-1)");
	}

	// driver 
	public static void main(String[] args) {
		TestQAlg test = new TestQAlg();
		int [] arr = {1,4,6,9,10,11,16};
		int B = Integer.parseInt(args[0]);
		int max = something(arr);
		System.out.println("Maximum of three highest array values multiplied is : ");
		System.out.println(max);
		System.out.println("And the following indices if they can be added to get B, other wise -1-1, ");
		test.somethingnewer(arr, B);
		System.out.println("And my version!");
		test.somethingnewer(arr, B);
	}

}