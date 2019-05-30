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