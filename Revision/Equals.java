class Equals {
  
  public static void main(final String[] args) {
    final int i1 = 5, i2 = 5, i3 = 6;
    System.out.println(i1 == i2); //truw
    System.out.println(i1 == i3); // false
    System.out.println(); // blank
    
    final X x1 = new X();
    System.out.println(x1.get()); //0
    System.out.println(x1 == x1);//true
    final X x2 = new X();
    System.out.println(x2.get());//0
    System.out.println(x1 == x2);//false
    System.out.println(x1.equals(x2)); //true
    x2.set(1);
    System.out.println(x1.equals(x2));//false
    final X x3 = x2;
    System.out.println(x1.equals(x3));//false
    x2.set(0);
    System.out.println(x1.equals(x3));//true
    System.out.println();//blank
    
    final String s1 = "abc";
    String s2 = "abc";
    System.out.println(s1 == s2); //true
    s2 = new String("abc");
    System.out.println(s1 == s2); //false
    System.out.println(s1.equals(s2));//true
    System.out.println();//blank
    
    final int[] a = {1,2,3};
    final int[] b = {1,2,3};
    System.out.println(a == b);//false
    System.out.println(a.equals(b)); //false
    System.out.println(equals(a, b));//true
    System.out.println();//blank
    
    final Integer I1 = new Integer(5);
    final Integer I2 = new Integer(5);
    System.out.println(I1 == I2); //false
    final Integer I3 = 5;
    final Integer I4 = 5;
    System.out.println(I3 == I4);//true
    System.out.println(I1 == I3);// false
    final Integer I5 = 128;
    final Integer I6 = 128;
    System.out.println(I5 == I6);//false
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