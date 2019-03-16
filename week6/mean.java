public class mean {
  public static void main(String[] args) {
    if (args.length ==0) return;
    final long N = Long.parseLong(args[0]);
    if (N <=0) return;
    long count = 0;
    double sum = 0;
    while (count < N && ! StdIn.isEmpty()) {
      sum += StdIn.readDouble(); // Reading floating point numbers from standard input 
      count++; //count increases until it reaches the number entered from command (NOT stdinput)
    }
    if (count< N){
      System.err.println("You have not entered enough numbers:  N= " + N + " expected, but only" + count + "found." );
      System.exit(1);
    }
    else    
    System.out.println(sum/N);
  }
}