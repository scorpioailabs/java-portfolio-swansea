class StdEx5 {
	public static void main(String[]args) {
		int N = Integer.parseInt(args[0]);
		int sum = 0;
		final int i = N + 5;
		do{
			sum += (N+=1);
		}
		while (N < i-1) ;
		System.out.println(sum);	
	}
}