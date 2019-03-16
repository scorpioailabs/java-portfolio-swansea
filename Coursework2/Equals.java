class Equals {
  
  public static void main(final String[] args) {
    final int i1 = 5, i2 = 5, i3 = 6;
    System.out.println(i1 == i2);
    System.out.println(i1 == i3);
    System.out.println();
    
    final X x1 = new X();
    System.out.println(x1.get());
    System.out.println(x1 == x1);
    final X x2 = new X();
    System.out.println(x2.get());
    System.out.println(x1 == x2);
    System.out.println(x1.equals(x2));
    x2.set(1);
    System.out.println(x1.equals(x2));
    final X x3 = x2;
    System.out.println(x1.equals(x3));
    x2.set(0);
    System.out.println(x1.equals(x3));
    System.out.println();
    
    final String s1 = "abc";
    String s2 = "abc";
    System.out.println(s1 == s2);
    s2 = new String("abc");
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    System.out.println();
    
    final int[] a = {1,2,3};
    final int[] b = {1,2,3};
    System.out.println(a == b);
    System.out.println(a.equals(b));
    System.out.println(equals(a, b));
    System.out.println();
    
    final Integer I1 = new Integer(5);
    final Integer I2 = new Integer(5);
    System.out.println(I1 == I2);
    final Integer I3 = 5;
    final Integer I4 = 5;
    System.out.println(I3 == I4);
    System.out.println(I1 == I3);
    final Integer I5 = 128;
    final Integer I6 = 128;
    System.out.println(I5 == I6);
  }
  
  private static boolean equals(final int[] a, final int[] b) {
    if (a == b) return true;
    if (a == null || b == null) return false;
    if (a.length != b.length) return false;
    for (int i = 0; i < a.length; ++i)
      if (a[i] != b[i]) return false;
    return true;
  }
}

class X {
  private int x;
  public void set(final int x_) { x = x_; }
  public int get() { return x; }
  public boolean equals(final X rhs) { return x == rhs.x; }
}