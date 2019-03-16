class Exercises07 {

  public static boolean odd(final boolean a, final boolean b, final boolean c) {
    final int ba = a ? 1 : 0;
    final int bb = b ? 1 : 0;
    final int bc = c ? 1 : 0;
    final int sum = ba + bb + bc;
    return (sum == 1) || (sum == 3);
  }
  
  public static boolean majority(final boolean a, final boolean b, final boolean c) {
    return (a && b) || (a && c) || (b && c);
  }
  
  public static boolean equal(final int[] a, final int[] b) {
    if (a == b) return true;
    if (a == null || b == null) return false;
    final int l = a.length;
    if (l != b.length) return false;
    for (int i = 0; i < l; ++i) if (a[i] != b[i]) return false;
    return true;
  }
  
  public static boolean triangular(final double a, final double b, final double c) {
    return (a < b+c) && (b < a+c) && (c < a+b);
  }
  
  private static boolean i2b(final int i) { return i >= 1; }
  
  /* Run with "java -ea Exercises07". */
  public static void main(final String[] args) {
  
    for (int i = 0; i <= 1; ++i)
      for (int j = 0; j <= 1; ++j)
        for (int k = 0; k <= 1; ++k) {
          final int sum = i + j + k;
          final boolean res = odd(i2b(i), i2b(j), i2b(k));
          assert(res == ((sum != 0) && (sum != 2)));
        }
    
    for (int i = 0; i <= 1; ++i)
      for (int j = 0; j <= 1; ++j)
        for (int k = 0; k <= 1; ++k) {
          final int sum = i + j + k;
          final boolean res = majority(i2b(i), i2b(j), i2b(k));
          assert(res == (sum >= 2));
        }
        
    {
     int[] a = null;
     int[] b = null;
     assert(equal(a,b));
     a = new int[0];
     assert(! equal(a,b));
     assert(! equal(b,a));
     b = new int[0];
     assert(equal(a,b));
     a = new int[2]; a[0] = 1; a[1] = 2;
     assert(! equal(a,b));
     assert(! equal(b,a));
     b = new int[2];
     assert(! equal(a,b));
     assert(! equal(b,a));
     b[0] = 1;
     assert(! equal(a,b));
     assert(! equal(b,a));
     b[1] = 2;
     assert(equal(a,b));
     assert(equal(b,a));
    }
    
    final int N = 100;
    for (int i = -N; i <= N; ++i) {
      final double di = (double) i;
      for (int j = -N; j <= N; ++j) {
        final double dj = (double) j;
        for (int k = -N; k <= N; ++k) {
          final double dk = (double) k;
          final boolean res = triangular(di,dj,dk);
          assert(res == ((di < dj+dk) && (dj < di+dk) && (dk < di+dj)));
        }
      }
    }
  }
}