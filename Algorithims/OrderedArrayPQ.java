//Ordered ARRAY pQ
public class OrderedArrayPQ {
	 private Object [] pq;      // elements
	 private int n;         // number of elements

	 // set inititial size of heap to hold size elements
	 public OrderedArrayPQ(int capacity) {
	     pq = new Object[capacity];
	     n = 0;
	 }

	 public boolean isEmpty()   { return n == 0; }
	 public int size()          { return n;      }
	 public Object delMax() { return pq[--n]; }
	 public Object delMin() { return pq[--n-n];
	 }
	 public void insert(Object key) {
	     int i = n-1;
	     while (i >= 0 && ((Integer)key < (Integer)pq[i])) {
	         pq[i+1] = pq[i];
	         i--;
	     }
	     pq[i+1] = key;
	     n++;
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
	     OrderedArrayPQ pq = new OrderedArrayPQ(10);
	     pq.insert(1);
	     pq.insert(2);
	     pq.insert(3);
	     pq.insert(4);
	     while (!pq.isEmpty()) 
	         StdOut.println(pq.delMax());
	 }
}