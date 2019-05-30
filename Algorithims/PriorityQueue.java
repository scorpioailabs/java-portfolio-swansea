// Priority Queue using Linked List 
public class PriorityQueue {
	private Node first; // link to least recently added node
	private Node last; // link to most recently added node
	private int n; // number of objects in the queue
	private class Node {
		// Nested class to define nodes
		Object data;
		//lower key values indicate higher priority
		int key;
		Node next;
	}
	// Function to create a new node
	public Node newNode(Object data, int p) {
		Node temp = new Node();
		temp.data = data;
		temp.key = p;
		temp.next = null;
		return temp;
	}
	public boolean isEmpty() {	return first == null; }
	public int size() {	return n; }

	public void insertItem(Object data, int key) {
		Node oldfirst = first;
		first = new Node();
		first.data = data;
		first.key = key;
		first.next = null;
		if (isEmpty()) first = last;
		else 		   first.next = oldfirst;
		n++;
	}
	public int removeMin() {
		if (first==null) {	return -1; }
		else if (n==1) { return first.key; }
		Node min = first, minPrev = null, current = min.next, prev = first;
		while(current!=null) {
			int currMin = min.key;
			int nextKey = current.key;
			if(nextKey < currMin) {
				min = current;
				minPrev = prev;
			}
			prev = current;
			current = current.next;
		}
		if(minPrev != null)
			minPrev.next=min.next;
		else
			first = min.next;
		n--;
		return min.key;
	}
	public int removeMax() {
		if (first==null) {	return -1; }
		else if (n==1) { return first.key; }
		Node max = first, maxPrev = null, current = max.next, prev = first;
		while(current!=null) {
			int currMax = max.key;
			int nextKey = current.key;
			if(nextKey > currMax) {
				max = current;
				maxPrev = prev;
			}
			prev = current;
			current = current.next;
		}
		if(maxPrev != null)
			maxPrev.next=max.next;
		else
			first = max.next;
		n--;
		return max.key;
	}

	public void printQueue() {
		//Traverse the list c.f. traversing an array
		Node node = first;
		while(node !=null) {
			System.out.println(node.data+":"+node.key);
			node = node.next;
		}
	}
	public static void main(String args[]) 
	{  
	    // Create a Priority Queue  
	    // 7.4.5.6 
	    PriorityQueue pQ = new PriorityQueue(); 
	    Node pq = pQ.newNode(4, 1);  
	    pQ.insertItem(10, 12);
	    pQ.insertItem(11, 13);    
	    pQ.insertItem(12, 14);  
	    pQ.insertItem(13, 15);
	    pQ.printQueue();      
	    System.out.println("(" + pQ.size() + " left in queue)" + "Minimum element: " + pQ.removeMin()
	     + " and Maximum element: " + pQ.removeMax());	    
	} 
}