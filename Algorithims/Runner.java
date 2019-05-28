//Runner for Linked List
public class Runner {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert("Zaki");
		list.insert("Ibrahim");
		list.insertAt(0, "Ali");
		list.deleteAt(1);
		list.printList();
	}
}