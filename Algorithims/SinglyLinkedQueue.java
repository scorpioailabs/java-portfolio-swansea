// Queue generic API using Linked List (singly)
public class SinglyLinkedQueue {
	private Node first; // link to least recently added node
	private Node last; // link to most recently added node
	private int n; // number of objects in the queue
	private class Node {
		// Nested class to define nodes
		Object obj;
		Node next;
	}
	public boolean isEmpty() {	return first == null; }
	public int size() {	return n; }
	public Object front() {
		return first.obj;
	}
	public void enqueue(Object obj) {
		// Add obj to the end of the list
		Node oldlast = last;
		last = new Node();
		last.obj = obj;
		last.next = null;
		if (isEmpty()) first = last;
		else 		   oldlast.next = last;
		n++;
	}
	public Object dequeue() {
		// Remove item from front of the list
		Object obj = first.obj;
		first = first.next;
		n--;
		if (isEmpty()) last = null;
		return obj;
	}
	public void printQueue() {
		//Traverse the list c.f. traversing an array
		for (Node node = first; node != null; node = node.next) {
			System.out.println(node.obj+" ");
		}
	}
}