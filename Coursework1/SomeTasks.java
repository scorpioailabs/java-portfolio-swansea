public class SomeTasks {
	public static void main (final String[] args){
		final int N = args.length;
		if (N ==0){
			System.out.println("994422");
			return;
		}		
		if (N ==1) {
			long newsum = 0;
			long oldsum = 0;
			final int nth = Integer.parseInt(args[0]);
			for(long i = 0; i <= nth; ++i){ 
				newsum += i * i;
				oldsum = newsum - i * i;
				if (newsum < oldsum) {
				System.out.println("Overflow at i =" + i);
					System.exit(1);
				}
			}
			System.out.println(newsum);
			return;
		}
		if (N ==2) {
			final long x = Integer.parseInt(args[0]);
			final long y = Integer.parseInt(args[1]);
			if (y > 0){
				System.out.println(x / y);
			}
			else if  (x > 0) {
				System.out.println(y / x);
			}
			else {
				System.out.println((-x) + (-y));
			}
			return;
		}
		if (N ==3) {
			final int a = Integer.parseInt(args[0]);
			final int b = Integer.parseInt(args[1]);
			boolean c = Boolean.parseBoolean(args[2]);
			if (c == true && (b >= a)) {
				for (int i = a; i <= b; ++i) {
				System.out.print(i + " ");
				}
				System.out.print(b);
			}
			else if (c == false && (b >= a)) {
				for (int i = a; i < b; ++i) {
				System.out.print(i + " ");
				}
				System.out.print(b);
			}
			return;	
		}
		if (N == 4) {
			final String s = args[0];
			int minlen = s.length();
			int newlen = s.length();
			for (int i = 0; i < N; ++i){
				newlen = args[i].length();
				if (newlen < minlen) minlen = newlen;
			}
			for (int j = 0; j < N; ++j){
				if (args[j].length() <= minlen)
					System.out.println(args[j]);
				}
				return;
		}
    if(N >= 5) {
     final long [] a = new long [N];
     for ( int i = 0; i < N; i++) a[i] = Long.parseLong(args[i]);
     long switchVar = 0;
      for (int i = 0; i < N; i++) {
      for(int j = i + 1; j < N; j++) {
        if ( a[i] > a[j]) {
          switchVar = a[j];
          a[j] = a[i];
          a[i] = switchVar;
    }
  }
}
    boolean var = true;
    for (int i = 0; i < N-1; i++) if ((a[i+1]-a[i]) != 1)
     var = false; System.out.println(var);
     return;
    }	
	}
}
