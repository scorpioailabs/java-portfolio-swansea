public class LinkedList {
	private Node first;
	private int n;
	private int m;

	private class Node {
	int item;
	Node next;
	Node(){}
	public Node(int i) { item = i; next = null; }
	}

	public void insertNode(Node new_node) {
		Node current;
		if (first == null) {
			new_node.next = first;
			first = new_node;
		}
		else {
			current = first;

			while (current.next != null) 
			{
				current = current.next;
			}			
			new_node.next = current.next;
			current.next = new_node;
		}
	}

	//function to create a node

	Node newNode(int item) {
		Node x = new Node(item);
		return x;
	}

	public Node advance_list(int long_len, int short_len, Node next) {
		int d = long_len - short_len;
		while (first != null && d >0) { // align point in longer list to first node in shorter list
			first = first.next;
			d --;
		}
		return first;
	}

	//function for printing linked list

	void printList() {
		Node temp = first;
		while (first != null) 
		{
			System.out.print(temp.item+" ");
			temp = temp.next;
		}
	}

	private int length(Node new_Node) {
		int length = 0;
		while (first != null) {
			length ++;
			first = first.next;
		}
		return length;
	}

	private Node findMergePoint(Node a, Node b) {
		int m = length(a);
		int n = length (b);
		int d = n - m;
		if(m > n) {
			Node temp = a;
			a = b;
			b = a;
			d = m - n;
		}

		//traversing d nodes of longer list i.e. l2
		for (int i=0; i<d; i++) {
			b = b.next;
		}

		while(a != null && b != null) {
			if(a == b) {
				return a;
			}
			a = a.next;
			b = b.next;
		}
		return null;
	}

	//Test client 

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		Node a;
		Node b;
		int i = 0;
		int j = 0;
		System.out.println("Please insert nodes in to Linked List L1: ");
		while (!StdIn.isEmpty()) {
			i = StdIn.readInt();
			a = l1.newNode(i);
			l1.insertNode(a);
		}
		System.out.println("Created Linked List");
		// l1.printList();
		System.out.println("Now please enter nodes for Linked List L2: ");
		while (!StdIn.isEmpty()) {
			j = StdIn.readInt();
			b = l2.newNode(j);
			l2.insertNode(b);
		}
		System.out.println("Created Linked List");
		// l2.printList();

	}
}

