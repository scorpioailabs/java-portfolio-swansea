public class Sum1{
 public static void main(final String[] args){  
       final int N = args.length;
       if (N == 1){  
        final int q = Integer.parseInt(args[0]);
         long sum = 0;
         long newsum = 0;
         for(long i = 0; i < q; ++i) {
          newsum += (i*i);
          if( newsum < sum) {
            System.out.println("Overflow at i = " + (i-1));
            System.exit(1);
          }
        }
        System.out.println( sum );
      }
    }
  }
