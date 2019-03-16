class StdEx1 {
	public static void main(String[]args){
		final int x = Integer.parseInt(args[0]);
		final int y = Integer.parseInt(args[1]);
		if (y > x){
			System.out.println(x + " " + y);

		}
		else{
			System.out.println(y + " " + x);
		}
	}

}
