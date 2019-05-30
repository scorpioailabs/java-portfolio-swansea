public class SinglyLinkedList {
	private Node first;
	private int n;
	private int m;

	private class Node {
	int item;
	Node next;
	Node(int i) { item = i; next = null; }
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

	//function for printing linked list

	void printList() {
		Node temp = first;
		while (first != null) 
		{
			System.out.print(temp.item+" ");
			temp = temp.next;
		}
	}

	private int length(Node x) {
		int length = 0;
		while (first != null) {
			length ++;
			first = first.next;
		}
		return length;
	}

	//Test client 

	public static void main(String[] args) {
		SinglyLinkedList l1 = new SinglyLinkedList();
		Node new_node;
		// while (!StdIn.isEmpty()) {
		// 	int i = StdIn.readInt();

		// }
		new_node = l1.newNode(5);
		l1.insertNode(new_node);
		new_node = l1.newNode(10);
		l1.insertNode(new_node);
		new_node = l1.newNode(13);
		l1.insertNode(new_node);
		new_node = l1.newNode(19);
		l1.insertNode(new_node);
		System.out.println("Created Linked List");
		l1.printList();
		System.out.println("Split the list! :");
		l1.printList();
	}
}

