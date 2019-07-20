/*package Coursera;
Eager approach does work regardless
O(N) for union and initiliase and constant time for connected
/**
 * QuickFind
 */
public class QuickFind {
    private int[] id;
    public QuickFind (int N) 
    {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i; //set id of each obj to itself (N array accesses)
        }
    }    
    public boolean connected (int p, int q)
    {   return id[p] == id[q];   }
    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            // chg all entries with id[p] to id[q] (at most 2N+2 array accesses)
            if (id[i] == pid) id[i] = qid;
        }
    }
}