/*StockAnalysis2************************************************
* Computes the max number of consecutive days a stock's price  *
* has been less than or equal to its price on d.			   *														   *
***************************************************************/
public class StockAnalysisTwo {
	public class Stack implements StackInterface {
		private Node first; // top of stack (most recently added node)
		private	int n; // Number of objs
		private class Node {
			// nested class to define nodes
			Object obj;
			Node next;
		}
		public boolean isEmpty() { return first == null; }
		public int size()		 {	return n;	}

		public void push(Object obj) {
			// Add obj to top of stack
			Node oldfirst = first;
			first = new Node();
			first.obj = obj;
			first.next = oldfirst;
			n++;
		}
		public Object pop() {
			// Remove obj from top of stack
			Object obj = first.obj;
			first = first.next;
			n--;
			return obj;
		}
		public void printStack() {
			//Traverse the list c.f. traversing an array
			for (Node node = first; node != null; node = node.next) {
				System.out.println(node.obj+" ");
			}
		}
		public Object top() {
			return first.obj;
		}
	}
	public int[] computeSpan(int[] arr) {
		int n = arr.length;
		Stack d = new Stack();
		int h = 0;
		int [] S = new int[n];
		for (int i =0; i < n; ++i) {
			boolean done = false;
			while (!d.isEmpty() && done == false) {
				if (arr[i] >= arr[(Integer)d.top()]) {
					d.pop();
				}
				else
					done = true;
			}
			if (d.isEmpty())
				h = -1;
			else
				h = (Integer)d.top();
			S[i] = i-h;
			d.push(i);
		}
		return S;
	}
}