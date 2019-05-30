// Array based Queue
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void enqueue( x )      --> Insert x
// Object getFront( )     --> Return least recently inserted item
// Object dequeue( )      --> Return and remove least recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// getFront or dequeue on empty queue
/**
 * Array-based implementation of the queue.
 * @author Zakariye Ali
 */
public class ArrayQueue implements Queue {
	public static final int CAPACITY = 1000; // default capacity of the queue
	private int N; // maximum capacity of the queue.
	private Object Q[ ]; // Q holds the elements of the queue
	private int f = -1; // the front element of the queue.
	private int r = 0;
	/**
	 * Construct the queue.
	 */
	public ArrayQueue(int cap) { // Initialize the stack with given capacity
		N = cap;
		Q = new Object[N];
	}
	/**
	 * Test if the queue is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {	return f == r; }
	    /**
     * Make the queue logically empty.
     */
    public void makeEmpty( )
    {
        N = 0;
        f = 0;
        r = -1;
    }
	public int size() {	return (N - f + r)%N; }
	public Object front() {
		if (isEmpty()) System.out.println("Queue underflow");
		return Q[f];	
	}
	public Object dequeue() {
		if (isEmpty()) System.out.println("Queue underflow");
		int temp = (Integer)Q[f];
		Q[f] = null;
		f = (f + 1)%N; // wrap around
		N--;
		return temp;
	}
	public void enqueue(Object obj) {
		if (isEmpty()) System.out.println("Queue underflow");
		Q[r] = obj;
		r = (r + 1)% N; // wrap around
		N++;
	}
	public void printQueue() {
		//Traverse the list c.f. traversing an array
		for (int i =0; i < size() - 1; ++i) {
			System.out.println(Q[i]);
		}
	}
	// Queue interface
	// ******************PUBLIC OPERATIONS*********************
	// void enqueue( obj )      --> Insert obj
	// Object front( )     --> Return least recently inserted item
	// Object dequeue( )      --> Return and remove least recent item
	// boolean isEmpty( )     --> Return true if empty; else false
	// ******************ERRORS********************************
}
interface Queue {
	public Object front();
		/**
		 * Return and remove the least recently inserted item
		 * from the queue.
		 * @return the least recently inserted item in the queue.
		 * @exception UnderflowException if the queue is empty.
		 */
	
	public void enqueue(Object obj);
		/**
		 * Get the least recently inserted item in the queue.
		 * Does not alter the queue.
		 * @return the least recently inserted item in the queue.
		 * @exception UnderflowException if the queue is empty.
		 */
	
	public Object dequeue();
		/**
		   * Test if the queue is logically empty.
		   * @return true if empty, false otherwise.
		*/

	public boolean isEmpty(); 	
		/**
		 * Make the queue logically empty.
		*/	
}