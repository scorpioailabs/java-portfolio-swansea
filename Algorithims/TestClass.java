class TestClass {
	// ----------- Code below -----------
    // ... put your codes here... if needed

    //intersect function provides an array that intersects A-B and A-C 
    //and also includes their components that intersect(A-B-C) 
    public static myArray intersect(myArray a, myArray b) {
        int [] A = a.arr; int N = a.n;
        int [] B = b.arr; int M = b.n;
        int [] C = new int[M+N]; //pre-allocated necessary space
        int i = 0; int j =0; int k =0;
        while(i < N && j < M) {
            if(A[i] == B[j]){ //i.e. matching elements and can be inserted into new array C
                C[k] = A[i];
                i++;
                j++;
                k++;
            }
            else if(A[i]<B[j]) //means A[i] and B[j] are different
                i++;
            else
                j++;
        }
        return new myArray(C,k);
    }
    //union function provides a set of elements which appear in A[] or B[] (i.e. unique elements).
    public static myArray union(myArray a, myArray b) {
        int [] A = a.arr; int N = a.n;
        int [] B = b.arr; int M = b.n;
        int [] C = new int[N+M]; //preallocated necessary space
        //initialise our incremental values
        int i =0; int j =0; int k =0;
        while(i < N && j < M ) {
            if(A[i] < B[j]){ //if A[i] is less than B[j] then it can't be present in A[i] and is therefore unique and can be 'joined' to C[]
                C[k] = A[i];
                i++;
                k++;
            }
            else if (A[i] > B[j]) { //if B[j] is less than A[i] then it can't be present in A[i] and is therefore unique and can be 'joined' to C[]
                C[k] = B[j];
                j++;
                k++;
            }
            else { //else A[i] and B[j] are the same and therefore we skip these elements
                i++;
                j++;
            }
        }
        //if B[] is finished; then whatever is remaining in A[] is unique, place in C[]
        while(i < N) {
            C[k] = A[i]; k++; i++;
        }
        //if A[] is finished; then whatever is remaining in B is unique, place in C[]
        while(j < M) {
            C[k] = B[j]; k++; j++;
        }             
        return new myArray(C,k);
    }
	// ----------- Code above -----------

	// ----------- Do not change codes below -----------
	public static void main(String args[] ) throws Exception {
		myArray a = new myArray(args[0]);
		myArray b = new myArray(args[1]);
		myArray c = new myArray(args[2]);
		Stopwatch st1 = new Stopwatch();
		// ----------- Do not change codes above -----------
		
		// You are not allowed to modify anything above
		// ----------- Code below -----------
		myArray x = union(intersect(a,c),intersect(b,c));    
		// ----------- Code above -----------
		// You are not allowed to modify anything below
		
		// ----------- Do not change codes below -----------
		x.printModulus();
		double time1 = st1.elapsedTime(); // the result in millis
		System.err.println("Elapsed Time: "+time1+" s");
		// ----------- Do not change codes above -----------
	}
}
