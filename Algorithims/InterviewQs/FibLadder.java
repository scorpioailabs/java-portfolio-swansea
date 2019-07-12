/*package InterviewQs;
You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:

with your first step you can stand on rung 1 or 2,
if you are on rung K, you can move to rungs K + 1 or K + 2,
finally you have to stand on rung N.
Your task is to count the number of different ways of climbing to the top of the ladder.

For example, given N = 4, you have five different ways of climbing, ascending by:

1, 1, 1 and 1 rung,
1, 1 and 2 rungs,
1, 2 and 1 rung,
2, 1 and 1 rungs, and
2 and 2 rungs.
Given N = 5, you have eight different ways of climbing, ascending by:

1, 1, 1, 1 and 1 rung,
1, 1, 1 and 2 rungs,
1, 1, 2 and 1 rung,
1, 2, 1 and 1 rung,
1, 2 and 2 rungs,
2, 1, 1 and 1 rungs,
2, 1 and 2 rungs, and
2, 2 and 1 rung.
/**
 * FibLadder
 */

public class FibLadder {
    //DP problem
    //K+1 OR K+2 <--- CHOICE GIVEN at K[i][j]
    public int[] numberOfSteps(int[] A, int[] B) {
        // write your code in Java SE 8
        int i;
        int N = A.length;
        int res =0;
        int[] K = new int[N+1];
        K[0]= 1; K[1]=1;
        //build cache array in bottom up manner
        for (i = 2; i <= N; i++) {
            K[i] = (K[i-1] + K[i-2]) % (int) Math.pow(2, 30);
        }
        for (i = 0; i < N; i++) {
            A[i] = K[A[i]] % (int) Math.pow(2, B[i]);
        }
        return A;      
    }
    public static void main(String[] args) {
        FibLadder f = new FibLadder();
        int[] A = {4,4,5,5,1};
        int[] B = {3,2,4,3,1};
        int[] res = f.numberOfSteps(A, B);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}