public class Max2 {

  public static int max(int x, int y) {
  	if (x > y) return x;
  	else return y;
  }
  public static int max(int a, int b, int c) {
  return max(max(a,b),c);  
  }
  public static  int max(final int a, final int b, final int c, final int d) {
  	return max(max(max(a,b),c),d);
  }

  public static void main(final String[] args) {
    final int a = Integer.parseInt(args[0]);
    final int b = Integer.parseInt(args[1]);
    final int c = Integer.parseInt(args[2]);
    final int d = Integer.parseInt(args[3]);
    System.out.println("The maximum of " + a + " , " + b + ", " + c + " and " + d + " is " + max(a,b,c,d) + ".");
  }
}