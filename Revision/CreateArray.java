public class CreateArray {

  public static int[] create(final int n) {
    if (n <= 0) return new int[0];
    final int[] a = new int[n];
    for (int i = 0; i < n; ++i) a[i] = i;
    return a;
  }

  public static void main(final String[] args) {
    final int[] a = create(Integer.parseInt(args[0]));
    for (int i = 0; i < a.length; ++i) System.out.print(a[i] + " ");
    System.out.println();
  }
}