public class StockAnalysis {
	public class ArrayStack implements StackInterface {
		public static final int Capacity = 1000; //default capacity of the stack
		private int capacity; //maximum capacity of the stack
		private Object S[]; //S holds the elements of the stack
		private int top = -1; //the top element of the stack
	}
}