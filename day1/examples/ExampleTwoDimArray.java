package day1.examples;

public class ExampleTwoDimArray {

	public static void main(String[] args) {
		//2D arrays are like a matrix
		
		int[][] TwoDim = new int [4][3];
		// note first box [] is the number of rows
		// and second box [] refers to number of columns
		// TwoDim[2][1] = 10;
		
		int temp = 10;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				
				TwoDim[i][j] = temp;
				temp += 10;
				
			}
		}
		// to print out the values like a matrix, omit the println until after:
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 3; j++) {
					
					System.out.print(TwoDim[i][j] + " ");
					
				}
				//printing empty line:
				System.out.println();
		}
	}

}


		
