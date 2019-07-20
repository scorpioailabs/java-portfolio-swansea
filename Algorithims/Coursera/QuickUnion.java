/*package Coursera;
Lazy approach- don't do work until needed
Takes O(N) to iniyialise, union and connected 
/**
 * QuickUnion
 */
public class QuickUnion {
    private int[] id;
    public QuickUnion (int N)
    {
        id = new int[N];
        //set id of each obj to itself (N array accesses)
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    private int root (int i)
    {
        //chase parent pointers until reach root
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
    public boolean connected (int p, int q) {
        // check if p and q have same root
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        // change root of p to point to root of q 
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}