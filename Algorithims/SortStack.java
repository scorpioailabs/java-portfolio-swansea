class SortStack {
	public static void main (String args[]) {
		ArrayStack S = new ArrayStack();
		ArrayStack T = new ArrayStack();
		S.push(new Integer(4));
		S.push(new Integer(1));
		S.push(new Integer(3));
		S.push(new Integer(2));

// ... Sort S ... into T
// ... your codes here ...

		while (!S.isEmpty()) {
			int x = (Integer)S.pop();

			while (!T.isEmpty() && ((Integer)T.pop() < x)) {
				S.push((Integer)T.pop());
			}

			T.push(x);
		}
// ... Print elements in T

		while(!T.isEmpty()) {
			System.out.print(T.pop() + ", ");
		}
		System.out.println();
	}
}
