public class cwtest {
	public static void main(final String[] args) {
		long a = 17;
		long b = 6;
		System.out.println(a/b);
	}
}



    // UNIT TESTING:
  public static void main(final String[] args) {
    final AbsorbingCounter c1 = new AbsorbingCounter(0, 10);
    assert(c1.val(0, 10) == 5);
    assert(! c1.reached_min(false));
    assert(! c1.reached_max(false));
    assert(c1.toString().equals("[0,5,10]"));
    assert(c1.equals(new AbsorbingCounter(0,10)));
    c1.inc(5); assert(c1.val(0, 10) == 6);
    assert(! c1.equals(new AbsorbingCounter(0,10)));
    c1.inc(6); c1.inc(7); c1.inc(8); c1.inc(9); assert(c1.val(0, 10) == 10);
    assert(c1.reached_max(true));
    c1.inc(10); assert(c1.val(0, 10) == 10);
    c1.dec(10); assert(c1.val(0, 10) == 10);
    assert(c1.reached_max(false));
    final AbsorbingCounter c2 = new AbsorbingCounter(-10,10);
    assert(c2.val(-10, 10) == 0);
    assert(! c2.equals(c1));
    assert(c2.equals(new AbsorbingCounter(-10,10)));
    assert(c2.equals(new AbsorbingCounter(10,-10)));
    for (int i = 0; i < 10; ++i) c2.dec(0);
    assert(c2.val(-10, 10) == -10);
    assert(c2.reached_min(true));
    c2.dec(-10); assert(c2.val(10, -10) == -10); assert(c2.reached_min(true));
    final AbsorbingCounter c3 = new AbsorbingCounter(0,10);
    assert(!c3.equals(c1));
    for (int i = 0; i < 5; ++i, c3.inc(5));
    assert(c3.equals(c1));
    final AbsorbingCounter c4 = new AbsorbingCounter(1,6);
    assert(c4.val(1, 6) == 3);
    c4.dec(3); c4.inc(2); assert(c4.equals(new AbsorbingCounter(1,6)));
    final AbsorbingCounter c5 = new AbsorbingCounter(0,0);
    assert(c5.val(0, 0) == 0);
    assert(c5.reached_min(true));
    assert(c5.reached_max(true));
    final AbsorbingCounter c6 = new AbsorbingCounter(Long.MIN_VALUE,Long.MAX_VALUE);
    assert(c6.val(0, 0) == 0);
    assert(!c6.equals(c5));
    AbsorbingCounter cn = new AbsorbingCounter(Long.MAX_VALUE,Long.MAX_VALUE);
    assert(cn.val(Long.MAX_VALUE,Long.MAX_VALUE) == Long.MAX_VALUE);
    assert(cn.reached_min(true));
    assert(cn.reached_max(true));
    cn = new AbsorbingCounter(Long.MAX_VALUE-1, Long.MAX_VALUE);
    assert(cn.val(Long.MAX_VALUE-1, Long.MAX_VALUE) == Long.MAX_VALUE-1);
    assert(cn.reached_min(true));
    assert(!cn.reached_max(false));
    cn = new AbsorbingCounter(Long.MIN_VALUE,Long.MIN_VALUE);
    assert(cn.val(Long.MIN_VALUE,Long.MIN_VALUE) == Long.MIN_VALUE);
    assert(cn.reached_min(true));
    assert(cn.reached_max(true));
    cn = new AbsorbingCounter(Long.MIN_VALUE+1, Long.MIN_VALUE);
    assert(cn.val(Long.MIN_VALUE+1, Long.MIN_VALUE) == Long.MIN_VALUE+1);
    assert(!cn.reached_min(false));
    assert(cn.reached_max(true));
    assert(new AbsorbingCounter(10,30).val(10,30) == 20);
    assert(new AbsorbingCounter(10,31).val(10,31) == 20);
    assert(new AbsorbingCounter(11,30).val(11,30) == 20);
    assert(new AbsorbingCounter(9,30).val(9,30) == 19);
    assert(new AbsorbingCounter(10,29).val(10,29) == 19);
    assert(new AbsorbingCounter(10,32).val(10,32) == 21);
    assert(new AbsorbingCounter(12,30).val(12,30) == 21);
    assert(new AbsorbingCounter(-10,10).val(-10,10) == 0);
    assert(new AbsorbingCounter(-10,11).val(-10,11) == 0);
    assert(new AbsorbingCounter(-11,10).val(-11,10) == 0);
    assert(new AbsorbingCounter(-9,10).val(-9,10) == 0);
    assert(new AbsorbingCounter(-10,9).val(-10,9) == 0);
    assert(new AbsorbingCounter(-10,12).val(-10,12) == 1);
    assert(new AbsorbingCounter(-8,10).val(-8,10) == 1);
    assert(new AbsorbingCounter(-12,10).val(-12,10) == -1);
    assert(new AbsorbingCounter(-10,8).val(-10,8) == -1);
    for (int x = -100; x <= 100; ++x)
      for (int y = -100; y <= 100; ++y) {
        final AbsorbingCounter c = new AbsorbingCounter(x, y);
        final double mean = ((double) x + y) / 2;
        final int mid = (int) mean;
        assert(c.val(x, y) == mid);
      }
    }
  }