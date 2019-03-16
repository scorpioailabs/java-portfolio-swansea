public class test{
  public static void main(final String[] args){
     final int N = args.length;
     if (N >= 5) {
      final long [] a = new long [N];
      for ( int i = 0; i < N; i++) a[i] = Long.parseLong(args[i]);
      long swapVar = 0;
      for (int i = 0; i < N; i++) {
        for(int j = i + 1; j < N; j++) {
          if ( a[i] > a[j]) {
            swapVar = a[j];
            a[j] = a[i];
            a[i] = swapVar;
          }
        }
      }
      boolean var = true;
      for (int i = 0; i < N-1; i++)
       if ((a[i+1]-a[i]) != 1)
        var = false; System.out.println(var);
        }
      }
    }
 
