import java.util.Random;

class AbsorbingCounter {
  // XXX instance variables
  private final long xmin, xmax;
  private long counter;

  public AbsorbingCounter(long min, long max) {
    // XXX
    if (min > max) {
      this.xmax = min; this.xmin = max;
    }
    else {
      this.xmin = min; this.xmax = max;
    }
    counter = (min + max) / 2; 
  }

  // XXX Five public methods (non-static functions)

  public long val() {
    return this.counter;
  }

  public void inc() {
    if (val() < this.xmax) this.counter++;
    }

  public void dec() {
    if (val() > this.xmin) this.counter--;
    }

  public boolean reached_min() {
        return this.counter == this.xmin;
  }

  public boolean reached_max() {
        return this.counter == this.xmax;
  }
  public String toString() {
    return "[" + this.xmin + "," + this.counter + "," + this.xmax + "]"; 
  }

  public boolean equals(final AbsorbingCounter other) {
    AbsorbingCounter that = (AbsorbingCounter) other;
    return that.xmin == this.xmin  && that.xmax == this.xmax && that.counter == this.counter;
  }

    // UNIT TESTING:
  public static void main(final String[] args) {
    final AbsorbingCounter c1 = new AbsorbingCounter(0, 10);
    assert(c1.val() == 5);
    assert(! c1.reached_min());
    assert(! c1.reached_max());
    assert(c1.toString().equals("[0,5,10]"));
    assert(c1.equals(new AbsorbingCounter(0,10)));
    c1.inc(); assert(c1.val() == 6);
    assert(! c1.equals(new AbsorbingCounter(0,10)));
    c1.inc(); c1.inc(); c1.inc(); c1.inc(); assert(c1.val() == 10);
    assert(c1.reached_max());
    c1.inc(); assert(c1.val() == 10);
    c1.dec(); assert(c1.val() == 10);
    assert(c1.reached_max());
    final AbsorbingCounter c2 = new AbsorbingCounter(-10,10);
    assert(c2.val() == 0);
    assert(! c2.equals(c1));
    assert(c2.equals(new AbsorbingCounter(-10,10)));
    assert(c2.equals(new AbsorbingCounter(10,-10)));
    for (int i = 0; i < 10; ++i) c2.dec();
    assert(c2.val() == -10);
    assert(c2.reached_min());
    c2.dec(); assert(c2.val() == -10); assert(c2.reached_min());
    final AbsorbingCounter c3 = new AbsorbingCounter(0,10);
    assert(!c3.equals(c1));
    for (int i = 0; i < 5; ++i, c3.inc());
    assert(c3.equals(c1));
    final AbsorbingCounter c4 = new AbsorbingCounter(1,6);
    assert(c4.val() == 3);
    c4.dec(); c4.inc(); assert(c4.equals(new AbsorbingCounter(1,6)));
    final AbsorbingCounter c5 = new AbsorbingCounter(0,0);
    assert(c5.val() == 0);
    assert(c5.reached_min());
    assert(c5.reached_max());
    final AbsorbingCounter c6 = new AbsorbingCounter(Long.MIN_VALUE,Long.MAX_VALUE);
    assert(c6.val() == 0);
    assert(!c6.equals(c5));
    AbsorbingCounter cn = new AbsorbingCounter(Long.MAX_VALUE,Long.MAX_VALUE);
    assert(cn.val() == Long.MAX_VALUE);
    assert(cn.reached_min());
    assert(cn.reached_max());
    cn = new AbsorbingCounter(Long.MAX_VALUE-1, Long.MAX_VALUE);
    assert(cn.val() == Long.MAX_VALUE-1);
    assert(cn.reached_min());
    assert(!cn.reached_max());
    cn = new AbsorbingCounter(Long.MIN_VALUE,Long.MIN_VALUE);
    assert(cn.val() == Long.MIN_VALUE);
    assert(cn.reached_min());
    assert(cn.reached_max());
    cn = new AbsorbingCounter(Long.MIN_VALUE+1, Long.MIN_VALUE);
    assert(cn.val() == Long.MIN_VALUE+1);
    assert(!cn.reached_min());
    assert(cn.reached_max());
    assert(new AbsorbingCounter(10,30).val() == 20);
    assert(new AbsorbingCounter(10,31).val() == 20);
    assert(new AbsorbingCounter(11,30).val() == 20);
    assert(new AbsorbingCounter(9,30).val() == 19);
    assert(new AbsorbingCounter(10,29).val() == 19);
    assert(new AbsorbingCounter(10,32).val() == 21);
    assert(new AbsorbingCounter(12,30).val() == 21);
    assert(new AbsorbingCounter(-10,10).val() == 0);
    assert(new AbsorbingCounter(-10,11).val() == 0);
    assert(new AbsorbingCounter(-11,10).val() == 0);
    assert(new AbsorbingCounter(-9,10).val() == 0);
    assert(new AbsorbingCounter(-10,9).val() == 0);
    assert(new AbsorbingCounter(-10,12).val() == 1);
    assert(new AbsorbingCounter(-8,10).val() == 1);
    assert(new AbsorbingCounter(-12,10).val() == -1);
    assert(new AbsorbingCounter(-10,8).val() == -1);
    for (int x = -100; x <= 100; ++x)
      for (int y = -100; y <= 100; ++y) {
        final AbsorbingCounter c = new AbsorbingCounter(x, y);
        final double mean = ((double) x + y) / 2;
        final int mid = (int) mean;
        assert(c.val() == mid);
      }
  }
}