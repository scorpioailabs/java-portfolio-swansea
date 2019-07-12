/*package InterviewQs;
Given a number n of units and c, the types of coins available
calculate how many ways you can get n from c.
For example, if you have  4 types of coins, and the value of each type as 8,3,1,2
is given as  respectively, you can make change for 3 units in three ways:{1,1,1} {1,2} and{3} .
/**
 * CoinChange
 */
public class CoinChange {
    // Complete the getWays function below.
    static  int max( int a,  int b) {
        return (a > b) ? a : b;
    }

    static  int getWays( int n,  int[] c) {
         int i, w;
        // number of types available
         int N = c.length;
        // create temp array to store visited 'cells'
         int K[][] = new  int[N + 1][ n + 1];

        // max ways to make change for 0 will be 1 i.e. doing nothing
        K[0][0] = 1;
        // build table K[][] in bottom up manner
        for (i = 1; i <= N; i++) {
            {
                //current cell = K[i-1][w]
                //current coin value = c[i-1]
                //set the subprob for the amount of 0 to 1 when solving this row
                K[i][0] = 1;
                for (w = 1; w <= n; w++) {
                    //if current coin value is lower than or equal to j 
                    // then number of ways to make change = choosing the ith coin or not choosing the ith coin 
                    if (c[  i - 1] <= w) {
                        K[i][w] = K[ i-1][ w] + K[ i][ (w-c[ i-1])];
                    }
                    //else don't choose the coin i.e. stick with current coin
                    else
                        K[  i][  w] = K[  i - 1][  w];
                }
            }
        }
        return K[N][n];
    }
    public static void main(String[] args) {
        int n = 4;
        int [] c = {1,2,3};
         int ways = getWays(n, c);
        System.out.println(ways);
    }

}