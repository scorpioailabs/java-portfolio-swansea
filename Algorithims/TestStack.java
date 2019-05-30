//TestClient for Stack Interface
public class TestStack {
	public static void main(String[] args) {
		StackInterface [] s = new StackInterface[1];
		s[0] = new Stack();
		while(!StdIn.isEmpty()) {
			String obj = StdIn.readString();
			if (!obj.equals("-"))
				s[0].push(obj);
			else if (!s[0].isEmpty()) StdOut.print(s[0].pop() + " ");
		}
		StdOut.println("(" + s[0].size() + " left on stack)");
		s[0].printStack();
		System.out.println(s[0].top());
	}
}