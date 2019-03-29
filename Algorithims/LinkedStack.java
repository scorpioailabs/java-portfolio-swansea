// Implementation of the Stack interface using an singly linked list.
public class LinkedStack implements StackInterface {
	private Node head;
	private int size;          

	public LinkedStack()
	{     
		head = null;
		size = 0;
	}
	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{       
		if (head == null)
			return true;
		return false;
	}
	public void push(Object data)
	{   
		Node n = new Node(data,head);
		head = n;
		size++;
	}
	public Object top()
	{
		if (isEmpty())
			System.out.println(" Stack is empty. ");
		return head.getData();
	}
	public Object pop() 
	{
		Object temp;
		if (isEmpty())
			System.out.println(" Stack is empty. ");
		temp = head.getData();
		head = head.getNext();            
		size--;
		return temp;
	}
}
