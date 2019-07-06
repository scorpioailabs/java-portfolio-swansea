//Red-black Balanced Search Tree
public class RedBlack<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	//nested Node class
	private class Node 
	{
		Key key;
		Value val;
		Node left, right;
		//colour of parent link
		boolean colour;
	}
	private boolean isRed(Node x)
	{
		if (x==null) return false; //null links are black
		return x.colour == RED;
	}
	// Search = same as BST (ignore colour) runs faster because of 
	// better balance
	public Value get(Key key)
	{
		return get(root, key);
	} 

	private Value get(Key key)
	{
		Node x = root;
		while (x != null)
		{
			int cmp = key.compareTo(x.key);
			// i.e. if y < x(v)
			if (cmp < 0) x = x.left;
			// y > x(v)
			else if (cmp > 0) x = x.right;
			// y == x(v)
			else if (cmp == 0) return x.val;
		}
		return null;
	}
	public void put(Key key, Value val)
	{
		// Seearch for key. Update value if found;
		// Grow table if new.
		root  = put(root, key, val);
	}

	private Node put(Node h, Key key, Value val)
	{
		if (h == null) return new Node(key, val, RED); //INSERT AT bottom and colour red
		int cmp = key.compareTo(h.key);		
		if (cmp < 0) h = h.left;
		else if (cmp > 0) h = h.right;
		else if (cmp == 0) return h.val;

		if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h); // lean left
		if (isRed(h.left)  && isRed(h.left.left)) h = rotateRight(h); .// no two red links adjacent
		if (isRed(h.left) && isRed(h.right)) flipColours(h); // split 4-node (in 2-3 tree)
	}

	private Node rotateLeft(Node h)
	{
		
	}	
}