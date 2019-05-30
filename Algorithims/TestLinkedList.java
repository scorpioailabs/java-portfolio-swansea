// Test client for linkedlist
public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList llist = new  LinkedList();
		llist.insert("zaki");
		llist.insert("ali");
		llist.insert("bey");
		llist.printList();
		llist.splitAfter(0);
		System.out.println("After split: ");
		llist.printList();
	}
}