/*package InterviewQs;
Given weights and values of n items, put these items in a knapsack of capacity W 
to get the maximum total value in the knapsack. In other words, 
given two integer arrays val[0..n-1] and wt[0..n-1]
which represent values and weights associated with n items respectively.
Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that 
sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
/**
 * KnapsackProblem
 */
public class KnapsackProblem {
    //utility function that returns max of two ints
    static int max(int a, int b) { return (a>b) ? a : b; }
    //return max val that can be put in a knapsack of capacity W
    static int knapsack(int W, int wt[], int val[], int n)
    {
        int i, w;
        //create our temp array to store visited vals
        int K[][] = new int [n+1][W+1];
        //build table K[][] in bottom up manner
        // if (i == 0 || w == 0) {
        //     K[i][w] = 0;
        // }
        K[0][0] =0;
        for (i = 1; i <= n; i++) {
            for (w = 1; w <= W; w++) {
                //if we have no items or maxweight we can take in collection
                //is 0 then the total weight in our collection is 0
                //take the current item in our collection
                //check if current val is less than or equal to j
                if (wt[i-1] <= w) {
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], 
                    K[i-1][w]);
                }
                //else leave current item from our collection
                else {
                    K[i][w] = K[i-1][w];
                }                 
            }
        }
        return K[n][W];
    }

    //driver code
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }
}