//Stack
public class Stack<Item> {
	private Node first; // top of stack (most recently added node)
	private	int n; // Number of items
	private class Node {
		// nested class to define nodes
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size()		 {	return n;	}

	public void push(Item item) {
		// Add item to top of stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}
	public Item pop(Item item) {
		// Remove item from top of stack
		item = first.item;
		first = first.next;
		n--;
		return item;
	}
	public void printStack() {
		//Traverse the list c.f. traversing an array
		for (Node node = first; node != null; node = node.next) {
			System.out.println(node.item+" ");
		}
	}
	// test client
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop(item) + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
		s.printStack();
	}
} 