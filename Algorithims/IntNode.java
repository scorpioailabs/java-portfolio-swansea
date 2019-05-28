public class IntNode {
	public IntNode first;
	public IntNode next;
	public int item;
	public int n;
	public int m;

	public IntNode(int item, IntNode next) {
		this.item = item;
		this.next = next;
	}

	public String toString() {
		return item + "";
	}

	// public void insertNode(Node new_node) {
	// 	Node current;
	// 	if (first == null) {
	// 		new_node.next = first;
	// 		first = new_node;
	// 	}
	// 	else {
	// 		current = first;

	// 		while (current.next != null) 
	// 		{
	// 			current = current.next;
	// 		}			
	// 		new_node.next = current.next;
	// 		current.next = new_node;
	// 	}
	// }

	// //function to create a node
	// Node newNode(int item) {
	// 	Node x = new Node(item);
	// 	return x;
	// }

	// //function for printing linked list
	// public void printList() {
	// 	Node temp = first;
	// 	while (first != null) 
	// 	{
	// 		System.out.print(temp.item+" ");
	// 		temp = temp.next;
	// 	}
	// }

	// public int length(Node x) {
	// 	int length = 0;
	// 	while (first != null) {
	// 		length ++;
	// 		first = first.next;
	// 	}
	// 	return length;
	// }

}

