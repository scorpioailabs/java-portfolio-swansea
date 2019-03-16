class odd {
	public static boolean isOdd(final boolean a, final boolean b, final boolean c) {
	    final int ba = a ? 1 : 0;
	    final int bb = b ? 1 : 0;
	    final int bc = c ? 1 : 0;
	    final int sum = ba + bb + bc;
	    return (sum == 1) || (sum == 3);
	}
	public static void main (final String [] args){
	}
}