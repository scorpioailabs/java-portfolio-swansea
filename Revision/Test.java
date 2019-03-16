public class Test {
	String name;
	public Test(String s){
		name = s;
	}
	public static void example(String str) {
		System.out.println("Hello, " + str);
	}
	public String stringy(String s) {
		String myName = s + name;
		return "Hello, " + myName;
	}
	public static void main(final String[]args) {
		String s = args[0];
		example(s);
	}
}