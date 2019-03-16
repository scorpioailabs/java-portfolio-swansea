class Bird {
	
}

class Peacock extends Bird {

}

public class Typeconv {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		Peacock p1 = new Peacock();

		b1 = p1; //allowed type conv
		//p1 = b1; //not allowed!  Bird is the superclass and Peacock is a subclass!
	}
}

class Type {
	double x;
	int y = 50;
	double sum = x + y;
}