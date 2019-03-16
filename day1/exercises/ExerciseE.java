package day1.exercises;

public class ExerciseE {

	public static void main(String[] args) {
		// pg 13 of handout 1.3 CSCM41
	/*	int N = Integer.parseInt(args[0]);*/
		
		// Powers of Two
		
		int N = 4; 
		int i = 0;
		int v = 1;
		while (i <= N) {
			System.out.println(i + " " + v);
			i += 1;
			v *= 2;
		}

	}

}
