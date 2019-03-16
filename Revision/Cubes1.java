public class Cubes1 {
	public static int cube(int i) {
		return i * i * i;
	}
	public static void main(String[]args) {
		int N = Integer.parseInt(args[0]);
		for (int i =0; i <= N; ++i) {
			System.out.println("Cube of " + i + " is " + cube(i));
		}
	}
}