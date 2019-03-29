// Implementation of the Stack interface using an array.
public class ArrayStack implements StackInterface {
	public static final int CAPACITY = 1000; // default capacity of the stack
	private int capacity; // maximum capacity of the stack.
	private Object S[ ]; // S holds the elements of the stack
	private int top = -1; // the top element of the stack.

	public ArrayStack( ) { // Initialize the stack
		this(CAPACITY);// with default capacity
	}
	
	public ArrayStack(int cap) { // Initialize the stack with given capacity
		capacity = cap;
		S = new Object[capacity];
	}

	public int size( ) { //Return the current stack size
		return (top + 1);
	}

	public boolean isEmpty( ) { // Return true if the stack is empty
		return (top < 0);
	}
	
	public void push(Object obj) { // Push a new object on the stack
		if (size() == capacity) {
			System.out.println("Stack overflow.");
		}
		S[++top] = obj;
	}

	public Object top() {
		// Return the top stack element
		if (isEmpty( )) {
			System.out.println("Stack is empty.");
		}
		return S[top];
	}

	public Object pop() {
		// Pop off the stack element
		if (isEmpty( )) {
			System.out.println("Stack is Empty.");
		}
		Object elem;
		elem = S[top];
		S[top--] = null; // Dereference S[top] and decrement top
		return elem;
	}
}
