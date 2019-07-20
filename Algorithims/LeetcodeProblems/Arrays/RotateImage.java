/*package LeetcodeProblems.Arrays;
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.
Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
/**
 * RotateImage
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int hi = matrix.length-1;
        int lo = 0;
        while(lo<hi) {
            int len = hi-lo;
            for (int i = 0; i < len; i++) {
                int index = lo + i;
                //index is our "pivot"
                swap(matrix, lo + i, hi, lo, index);
                swap(matrix, hi, hi-i, lo, index);
                swap(matrix, hi-i, lo, lo, index); 
            }
            lo++;
            hi--; 
        }

    }
    public void swap(int[][]matrix, int i, int j, int k, int l){
        int temp = matrix[k][l];
        matrix[k][l]= matrix[i][j];
        matrix[i][j] = temp;
    }
    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        r.rotate(matrix);
    }
}