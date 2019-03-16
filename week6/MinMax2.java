public class MinMax2 {
	 public static void main(final String[] args) {
    long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    while (!StdIn.isEmpty()) {
      long val = StdIn.readInt();
      while (val <= 0) {
        System.err.println("All numbers must be positive, " + val +
          " is not allowed - please reenter:");
        val = StdIn.readInt();
      }
		if (val > max) max = val;
		if (val < min) min = val;
    }
    System.out.println("Minimum = " + min);
    System.out.println("Maximum = " + max);
  }
}