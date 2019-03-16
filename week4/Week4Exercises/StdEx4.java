class StdEx4 {
	public static void main(String[]args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);

		for (int i=0; i <N; ++i){
			System.out.print("Hello World");
			for (int j=0; j < M; ++j){
				System.out.print("!");
			}
			System.out.print("\n");
		}

	}
}