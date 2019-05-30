// 	Test client for ArrayQueue
public class TestArrayQ {
	public static void main(String[] args) {
		SortingClient print = new SortingClient();
		int [] P = { 2, 4, 4, 3, 8, 9, 2, 3, 11, 5};
		ArrayQueue aq = new ArrayQueue(P.length);
		for (int i = 0; i < P.length; ++i) {
			aq.enqueue(P[i]);
		}
		// aq.makeEmpty();
		System.out.println(aq.size() + " left in queue!");
		aq.printQueue();
	}
}