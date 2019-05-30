//Priority Queue using Array 
public class UnorderedArrayPQ {
    private Object [] pq;      // elements
    private int n;         // number of elements

    // set inititial size of heap to hold size elements
    public UnorderedArrayMaxPQ(int capacity) {
        pq = new Object[capacity];
        n = 0;
    }

    public boolean isEmpty()   { return n == 0; }
    public int size()          { return n;      }
    public void insert(Object x)  { pq[n++] = x;   }

    public Object delMax() {
        int max = 0;
        for (int i = 1; i < n; i++) {


            if ((Integer)pq[i] > max){
            	max = i;	
            }
        }
        exch(max, n-1);
        return pq[--n];
    }

    public Object delMin() {
        int min = 0;
        for (int i = 1; i < n; i++){
            if ((Integer)pq[i] < min) {
            	min = (Integer)pq[i];
            }
        }
        exch(min, n-1);
        return pq[--n];
    }


   /***************************************************************************
    * Helper functions.
    ***************************************************************************/

    private void exch(int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


   /***************************************************************************
    * Test routine.
    ***************************************************************************/
    public static void main(String[] args) {
        UnorderedArrayMaxPQ pq = new UnorderedArrayMaxPQ(10);
        pq.insert(23);
        pq.insert(232);
        pq.insert(22);
        pq.insert(2);
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }

}