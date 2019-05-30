//Stack
public class Stack implements StackInterface {
	private Node first; // top of stack (most recently added node)
	private	int n; // Number of objs
	private class Node {
		// nested class to define nodes
		Object obj;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size()		 {	return n;	}
	public void push(Object obj) {
		// Add obj to top of stack
		Node oldfirst = first;
		first = new Node();
		first.obj = obj;
		first.next = oldfirst;
		n++;
	}
	public Object pop() {
		// Remove obj from top of stack
		Object obj = first.obj;
		first = first.next;
		n--;
		return obj;
	}
	public void printStack() {
		//Traverse the list c.f. traversing an array
		for (Node node = first; node != null; node = node.next) {
			System.out.println(node.obj+" ");
		}
	}
	public Object top() {
		return first.obj;
	}
} 