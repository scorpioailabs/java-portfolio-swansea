public class Trivial {
	// instance variables:
	public final int a;
	public final int b;
	//constructor Trivial has two paramater variables
	public Trivial(final int x, final int y) {
		a = x;
		b = y;
	}
	//non static method sum sums the values of two parameter variables declared
	public int sum() {
		return a + b;
	}
	// non static method computes the values of two parameter variables declared
	public int product() {
		return a*b;
	}

	public String toString() {
		return a + ", " + b;
	}

	public boolean equals(final Trivial other) {
		if (other == null) return false;
		return ((a==other.a) && (b==other.b)) || ((a==other.b) && b==other.a);
	}
	//method needs to reference Object
	public Trivial multiply(final int m) {
		return new Trivial(a*m, b*m);
	}


}