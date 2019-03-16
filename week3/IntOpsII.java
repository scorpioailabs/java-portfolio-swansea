package week3;

public class IntOpsII   {
    public static void main (final String [] args)  {
        if (args.length != 2) {
            System.err.println("The system was expecting two arguments, you've entered " + args.length); 
        // To avoid nested statements, use the return; command to exit program;
            return;
        }
        final int a = Integer.parseInt(args[0]);
        final int b = Integer.parseInt(args[1]);
        final int p = a*b;
        final int q = a/b;
        final int r = a%b;
        System.out.println(a + " * " + b + " = " + p);
        System.out.println(a + " / " + b + " = " + q);
        System.out.println(a + " % " + b + " = " + r);
        System.out.println(a + " = " + q + " * " + b + " + " + r);
    }
}

