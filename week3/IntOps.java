package week3;

public class IntOps {
	public static void main(String[] args) {
		int a = Integer.parseInt(args [0]);
		int b = Integer.parseInt(args[1]);
		int p = a*b;
		int q = a/b;
		int r = a%b;
		System.out.println(a + " * " + b + " = " + p);
		System.out.println(a + " / " + b + " = " + q);
		System.out.println(a + " % " + b + " = " + r);
		System.out.println(a + " = " + q + " * " + b + " + " + r);
	}
}

/* problems with code above:
    what if number is decimal, so we need to enter error message for non int numbers
    /*
    
// Tell the compliler that int a and b are final
// reason for final is because in this example a & b are constants we use final same for p, q and r
// need to implement error mechanism for args input
// need to only accept if it's 2 args
// So let's add an if condition for userimput
// Add System.err.println message

