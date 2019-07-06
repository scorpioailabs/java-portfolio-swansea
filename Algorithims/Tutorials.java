//Tutorials
public class Tutorials {
	public static int PowerOf2 (int n) {
	 // your codes here…
		// n = number of times 2 x itself
		// base case
		if (n == 0)
			return 1;
		else {
			//general case
			return 2 * PowerOf2(n-1);
		}

	}

	public int[] sumOfKNumbers(int n) {
		int[] kTimes = new int [2];
		int k =0;
		int l = 0;
		for (int i =0; i < n; i++) {
			for (int j = 3; j < n; j++) {
				//C1
				k++;
			}
			//C2			
			l++;
		}
		kTimes[0] = k;
		kTimes[1] = l;
		return kTimes;
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int pow = PowerOf2(n);
		System.out.println(pow);
		Tutorials t = new Tutorials();
		int [] a = t.sumOfKNumbers(n);
		System.out.println("code A  is " + a[0] + " and code B executed " + a[1] + "times");
	}

	pu

}