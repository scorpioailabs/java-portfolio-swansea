//Stack
public class Stack implements StackInterface {
	private Node top; // top of stack (most recently added node)
	private	int n; // Number of objs
	private class Node {
		// nested class to define nodes
		Object obj;
		Node next;
	}
	public boolean isEmpty() { return top == null; }
	public int size()		 {	return n;	}
	public void push(Object obj) {
		// Add obj to top of stack
		Node oldtop = top;
		top = new Node();
		top.obj = obj;
		top.next = oldtop;
		n++;
	}
	public Object pop() {
		// Remove obj from top of stack
		Object obj = top.obj;
		top = top.next;
		n--;
		return obj;
	}
	public void printStack() {
		//Traverse the list c.f. traversing an array
		for (Node node = top; node != null; node = node.next) {
			System.out.println(node.obj+" ");
		}
	}
	public Object top() {
		return top.obj;
	}
} 