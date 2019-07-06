// Linked List
public class LinkedList {
	private Node head;
	private int n;
	private int m;

/** Constructor */
	public LinkedList() {
		head = null;
	}

	public LinkedList(Node newNode) {
		head = newNode;
	}

	private class Node {
		Object data;
		Node next;
	}

	public void insert(Object data) {
		Node node  = new Node();
		node.data = data;
		node.next = null;
		if (head== null) {
			head = node;
		}
		else {
			Node n = head;
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
		node.next = head;
		head = node;
	}
	public void insertAt(int index, Object data) {
		Node node  = new Node();
		node.data = data;
		node.next = null;

		if (index ==0) {
			insertAtStart(data);
			return;
		}

		Node n = head;
		for(int i=0; i < index-1; ++i) {
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
	}

	// removing node
	public void deleteAt(int index) {
		if(index==0) {
			head = head.next;
		}
		else {
			Node n = head;
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
		Node tmpNode = head;
		int i =0;
		while (i < pos) {
			tmpNode = tmpNode.next;
			i = i + 1;
		}
		LinkedList newList = new LinkedList(tmpNode.next);
		tmpNode.next = null;
		return newList;
	}

	//return count of object occurrence in linked list
	int count(Object search_for) 
	{ 
	    Node current = head; 
	    int count = 0; 
	    while (current != null) { 
	        if (current.data == search_for) 
	            count++; 
	        current = current.next; 
	    } 
	    return count; 
	}

	//access a node in a linked list
	public Node get(int index)
	{
		Node current = head;
		int count = 0;
		while (count != index) {
			current = current.next;
		    count++; 
		}
		return current;
	}

	//function for printing linked list
	void printList(Node node) {
		while (node.next != null) 
		{
			System.out.println(node.data + " ");
			node = node.next;
		}
		System.out.println(node.data);
	}
	//function for printing a linked list w/o arguments
	void printList()
	{
		Node node = head;
		while(node.next != null)
		{
			System.out.println(node.data + " ");
			node = node.next;
		}
		System.out.println(node.data);	
	}

	//iterative method for reversing a list
	public static Node reverse(Node node)
	{
		//conditions
		if(node == null || node.next == null) {	return node; }
		//otherwise
		//Remaining nodes to be reversed
		Node next = null;
		//Link to nodes that have already been reversed
		Node prev = null;
		//Pointer to current node
		Node current = node;
		//traverse the to-do list:
		while(current != null)
		{
			//store a reference to next node in list
			next = current.next;
			//Point the next node to previous node
			current.next = prev;
			//Set previous node to current node
			prev = current;
			//Set current node to 
			current = next;
		}
		node = prev;
		return node;
	}

	//recursive method for reversing a list
	public Node recursiveReverse(Node current, Node prev)
	{
		//base case
		if(current.next == null) 
		{
			head = current;
			//update next to previous node
			current.next = prev;
			return head;
		}
		//general case
		//store a reference to next node in list
		Node next = current.next;
		//point the next node to previous node
		current.next = prev;
		//recursively reverse the next and current nodes until base case
		recursiveReverse(next, current);
		return head;
	}

	//client code
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert((int)5);
		list.insert((int)3);
		list.insert((int)7);
		list.insert((int)9);
		list.insert((int)2);
		list.insert((int)10);
		System.out.println("Original Linked List: ");
		list.printList(list.head);
		// Node newHead = reverse(list.head);
		// System.out.println("Reversed List:");
		// list.printList(newHead);
		System.out.println("The recursive approach:");
		Node recHead = list.recursiveReverse(list.head, null);
		list.printList(recHead);
	}
}

