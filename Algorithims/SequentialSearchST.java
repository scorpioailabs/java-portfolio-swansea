public class SequentialSearchST<Key, Value> {
	private int n; //number of key-value pairs
	private Node first; //the linked list of key-value pairs
	// a helper linked list data type
	private class Node {
		private Key key;
		private Value val;
		private Node next;
		public Node(Key key, Value val, Node next) //Node is a constructor of class Node
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	/*Initiliases an empty symbol table
	*/
	public SequentialSearchST() {

	}

	/*Return the number of key-value pairs in the table
	*/

	public int size() {
		return n;
	}

	/*
	Return true if symbol table contains the specified key, 
	throw argument if table contains null
	*/
	public boolean contains(Key key) {
		if (key ==null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	// returns value associated with given key in table:
	public Value get(Key key) {
		if (key ==null) throw new IllegalArgumentException("argument to contains() is null");
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}
	
		/*Insets the specified key-value pair into the table,
		overwriting the old calue with new value, if table
		already contains the specified key. Deletes key
		if its specified value is null
		*/

	public void put(Key key, Value val) {
		if (key == null) throw new IllegalArgumentException("argument to put() is null");
		if (val ==null) {
			delete(key);
			return;
		}

		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		n++;

	}
		

	/*Removes specified key and its associated value
	from table (if key is in table)
	*/
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		first = delete(first, key);
	}

		//delete key in linked list beginning at Node x
	private Node delete(Node x, Key key) {
		if (x == null) return null;
		if (key.equals(x.key)) {
			n--; //size of table decreases by one
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	/* Return all keys in the symbol table as an {Iterable}
	
	*/
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }


	//TestClient :
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i =0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
 	}
}