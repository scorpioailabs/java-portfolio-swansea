// Test client for queue
public class TestQueue {
	public static void main(String[] args) {
		Queue q = new Queue();
		while(!StdIn.isEmpty()) {
			String obj = StdIn.readString();
			if (!obj.equals("-"))
				q.enqueue(obj);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		q.dequeue();
		StdOut.println("(" + q.size() + " left in queue)");
		q.printQueue();
	}
}