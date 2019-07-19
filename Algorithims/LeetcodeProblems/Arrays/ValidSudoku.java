/*package LeetcodeProblems.Arrays;
Determine if a 9x9 Sudoku board is valid. 
Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
/**
 * ValidSudoku
 */
import java.io.*;
 public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] squares = new short[9];
        for (int row  = 0; row < board.length; row++) {
            for(int col=0; col< board[0].length; col++) {
                if(board[row][col] == '.') continue;
                short value = (short)(1<<(board[row][col]-'1'));
                //check for duplicates using AND bitwise operator rep'd by & 
                if((value & rows[row])>0) return false;
                if((value & cols[col])>0) return false;
                if((value & squares[3*(row/3) + col/3])>0) return false;
                //|= is OR operator
                rows[row] |= value;
                cols[col] |= value;
                squares[3*(row/3) + col/3] |= value;
            }
        }
        return true;
    }    
}