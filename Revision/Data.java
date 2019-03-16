class Data {
  int x;
  double y;
  boolean y_pos;

  public Data() { x=1; y=-1; y_pos = false; }
  public Data(final int x0, final double y0) {
    x = x0; y = y0; y_pos = y > 0;
  }
  public void setx(final int x0) { x = x0; }
  public int getx() { return x; }
  public void sety(final double y0) { y = y0; y_pos = y > 0; }
  public double gety() { return y; }
  public boolean ypos() { return y_pos; }
  
  public String toString() { return "(" + x + "," + y + ")"; }
  public boolean equals(final Data other) {
    return x == other.x && y == other.y;
  }
  
  // Unit testing:
  public static void main(final String[] args) {
    final Data d = new Data();
    assert(d.getx() == 1);
    assert(d.gety() == -1);
    assert(! d.ypos());
    System.out.println(d);
    d.setx(77);
    assert(d.getx() == 77);
    assert(d.gety() == -1);
    assert(! d.ypos());
    System.out.println(d);

    final Data d2 = new Data(44, 3.1);
    assert(d2.getx() == 44);
    assert(d2.gety() == 3.1);
    assert(d2.ypos());
    assert(! d2.equals(d));
    System.out.println(d2);
    d2.setx(77);
    d2.sety(-1);
    assert(d2.equals(d));
    assert(d.equals(d2));

    // Attention: MISUSE (note that HERE we can access d2.y)
    d2.y = 1;
    assert(d2.ypos()); // ASSERTS
  }
}