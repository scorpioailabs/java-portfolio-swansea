class Exercises8 {
	public static boolean leq(final int a, final int b){
		boolean result = true;
		if (a <= b) result = true;
		else result = false;
		return result;
	}
	public static double sgn(final double x){
		if (x < 0) return -1;
		if (x > 0) return +1;
		return 0;
	}
	public static int[] fill(int a, int b, int c){
		final int[] result = {a,b,c};
		return result;
	}
	public static int[] sort(int a, int b, int c){
		final int[] sorted = {a,b,c};
		if(sorted[1] < sorted[0]) swap(sorted,0,1);
		if(sorted[2] < sorted [1])swap(sorted,1,2);
		if(sorted[1] < sorted [0])swap(sorted,0,1); 
		return sorted;
	}
	public static long pow2(final int e){
		final int a = 1;
		final int b = 2;
		long eqn = 1;
		for(int i =0; i< e; i++) {
			eqn *= a * b;
		}
		return eqn;
	}
	public static boolean eqarr(final int []a, final int []b){
		if (a == null && b == null) return true;
		if (a == null || b == null) return false;
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; ++i)
			if (a[i] != b[i]) return false; 
		return true;
	}
	public static boolean and(final boolean [] a){
		if(a ==null) return true; //all the elements are true if the array is full of null values
		for (int i =0; i < a.length; ++i) if (!a[i]) return false; //runs through array and any element that's not an 'element' is false!
		return true;
	}
	public static boolean xor(final boolean [] a){
		if (a == null) return false; /*this time since only if an odd number of elements render bool array as true, 
		if they're all null then obviously we would return a false argument.*/
		int count = 0;
		for (int i = 0; i < a.length; ++i) if (a[i]) count++;
		return count % 2 == 1; // if there's a remainder then there would be an odd number of true elements
	}


//swap function to use for sort exercise:
	private static void swap(final int[] a, final int i, final int j) {
    final int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

//testing:

  public static void main(final String[] args) {

    assert(leq(1,1) == true);
    assert(leq(1,2) == true);
    assert(leq(1,0) == false);

    assert(sgn(-2) == -1);
    assert(sgn(0.0) == 0);
    assert(sgn(4.7) == 1);
    assert(sgn(Double.NaN) == 0); // so well
    assert(sgn(Double.POSITIVE_INFINITY) == 1);
    assert(sgn(Double.NEGATIVE_INFINITY) == -1);

    assert(eqarr(fill(1,2,3), sort(3,2,1)));
    assert(eqarr(fill(1,2,3), sort(1,2,3)));
    for (int i = -3; i <= 3; ++i)
      for (int j = -3; j <= 3; ++j)
        for (int k = -3; k <= 3; ++k)
    assert(xor(null) == false);
    boolean[] a = new boolean[0];
    assert(and(a) == true);
    assert(xor(a) == false);
    a = new boolean[1];
    assert(and(a) == false);
    assert(xor(a) == false);
    a[0] = true;
    assert(and(a) == true);
    assert(xor(a) == true);

        }
    }

