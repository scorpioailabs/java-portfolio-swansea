public class Client {
	public static void main(final String[] args) {
	    final int x0 = Integer.parseInt(args[0]);
	    final int y0 = Integer.parseInt(args[1]);
	    final int x1 = Integer.parseInt(args[2]);
	    final int y1 = Integer.parseInt(args[3]);

	    final Trivial t0 = new Trivial(x0,y0);
	    final Trivial t1 = new Trivial(x1,y1);

	    System.out.println(t0.sum());
	    System.out.println(t0.product());
	    System.out.println(t0);
	    System.out.println(t1.sum());
	    System.out.println(t1.product());
	    System.out.println(t1);
	    System.out.println(t0.equals(t1));
	    System.out.println(t1.multiply(t0.sum()));
  }
}