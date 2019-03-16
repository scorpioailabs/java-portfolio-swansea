public class PassByValue2 {
  static void update(int a, final int[] b, String c) {
    a    = 7;
    b[3] = 7;
    c    = "seven";
    System.out.println(a + " " + b[3] + " " + c);
  }
  public static void main(final String[] args) {
    final int a = 3;
    final int[] b = { 0, 1, 2, 3, 4, 5 };
    final String c = "three";
    System.out.println(a + " " + b[3] + " " + c);
    update(a, b, c);
    System.out.println(a + " " + b[3] + " " + c);
  }
}