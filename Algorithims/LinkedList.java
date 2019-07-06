// Linked List
public class LinkedList {
	private Node first;
	private int n;
	private int m;

/** Constructor */
	public LinkedList() {
		first = null;
	}

	public LinkedList(Node newNode) {
		first = newNode;
	}

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

	// split in to two
	public LinkedList splitAfter(int pos) {
		Node tmpNode = first;
		int i =0;
		while (i < pos) {
			tmpNode = tmpNode.next;
			i = i + 1;
		}
		LinkedList newList = new LinkedList(tmpNode.next);
		tmpNode.next = null;
		return newList;
	}

	int count(Object search_for) 
	{ 
	    Node current = first; 
	    int count = 0; 
	    while (current != null) { 
	        if (current.data == search_for) 
	            count++; 
	        current = current.next; 
	    } 
	    return count; 
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

