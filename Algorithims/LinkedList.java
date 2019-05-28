// Linked List
public class LinkedList {
	private Node first;
	private int n;
	private int m;

	private class Node {
		Object data;
		Node next;
	}

	public void insert(Object data) {
		Node node  = new Node();
		node.data = data;
		node.next = null;
		if (first== null) {
			first = node;
		}
		else {
			Node n = first;
			while(n.next!= null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void insertAtStart(Object data) {
		Node node  = new Node();
		node.data = data;
		node.next = null;
		node.next = first;
		first = node;
	}
	public void insertAt(int index, Object data) {
		Node node  = new Node();
		node.data = data;
		node.next = null;

		if (index ==0) {
			insertAtStart(data);
			return;
		}

		Node n = first;
		for(int i=0; i < index-1; ++i) {
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
	}

	// removing node
	public void deleteAt(int index) {
		if(index==0) {
			first = first.next;
		}
		else {
			Node n = first;
			Node n1 = null;
			for (int i = 0; i< index-1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
		}
	}

	//function for printing linked list

	void printList() {
		Node node = first;
		while (node.next != null) 
		{
			System.out.println(node.data + " ");
			node = node.next;
		}
		System.out.println(node.data);
	}

}

