public class Max2 {

  public static int max(int x, int y) {
    int z;
    if (x > y) x = z; y = x;
    else y = z;
    return z;
  }

  public static void main(final String[] args) {
    final int a = Integer.parseInt(args[0]);
    final int b = Integer.parseInt(args[1]);
    System.out.println("The maximum of " + a + " and " + b + " is " + max(a,b) + ".");
  }
}