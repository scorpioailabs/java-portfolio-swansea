//A binary search Tree algorithm
public class BinaryTree<Key extends Comparable<Key>, Value> {
	private Node root;					//root of BinaryTree
	private class Node {
		private Key key;				// key
		private Value val;				// associated value
		private Node left, right;		// links to subtrees
		private int n; 					// # nodes in subtree rooted here
		public Node(Key key, Value val, int n)
		{
		    this.key = key;  this.val = val;  this.n = n;
		}
	}

	// Public method to return size of tree
	public int size()
	{
		return size(root);
	}

	// Return the number of nodes in tree
	private int size(Node x)
	{
		if (x == null) return 0;
		else 		   return x.n;
	}

	public boolean isEmpty() { return root == null; }

	public Value get(Key key)
	{
		return get(root, key);
	} 

	/*
	* Return value associated with key in subtree
	* rooted at x;
	* return null if key s not present in subtree
	*/
	private Value get(Node x, Key key)
	{
		//search routine!
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		// if y =< x(v)
		if (cmp<0) return get(x.left,key);
		// else if y >= x(v)
		else if (cmp>0) return get(x.right,key);
		// else y == x(v) return value of key
		else return x.val;
	}

	public void put(Key key, Value val)
	{
		// Seearch for key. Update value if found;
		// Grow table if new.
		root  = put(root, key, val);
	}

	/* This method searches BinaryTree and inserts a key's value
	* with search value if in subtree, else, it addes a new
	* node to subtree associating the key with the search value.
	*/
	private Node put(Node x, Key key, Value val)
	{
		// Change key's value to val if key in subtree
		// rooted at x. Else, add new node to subtree
		// associating key with val.
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp<0) x.left = put(x.left,key, val);
		else if (cmp>0) x.right = put(x.right, key, val);
		else x.val = val;
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Key min()
	{
		if(isEmpty())
			System.out.println("Tree is empty!");
		Node x = min(root);
		return x.key;
	}
	/*
	* Return the node with minimum key element
	* Go left until finding a node with a null
	* left link 
	*/
	private Node min(Node x)
	{
		if(x.left == null) return x;
		return min(x.left);
	}

	public Key max()
	{
		if(isEmpty())
			System.out.println("Tree is empty!");
		Node x = max(root);
		return x.key;
	}
	/*
	* Return the node with maximum key element
	* Go right until finding a node with a null
	* right link 
	*/
	private Node max(Node x)
	{
		if(x.right == null) return x;
		return max(x.right);
	}
	
	public void deleteMin()
	{
		if (isEmpty())
			System.out.println("Tree is empty!");
		root = deleteMin(root);
	}
	/*
	* This method removes a key-value pair from the tree, by going
	* left until we find a Node that has a null left link and replace the
	* link to that node by its right link 
	*/
	private Node deleteMin(Node x)
	{
		// base case
		if(x.left == null) return x.right;
		//recursively traverse left link
		x.left= deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMax()
	{
		if(isEmpty())
			System.out.println("Tree is empty!");
		root = deleteMax(root);
	}

	/*
	* This method removes a key-value pair from the tree, by going
	* right until we find a Node that has a null right link and replace the
	* link to that node by its left link 
	*/
	public Node deleteMax(Node x)
	{
		// base case
		if(x.right == null) return x.left;
		// recursively traverse right link
		x.right = deleteMax(x.right);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void delete(Key key)
	{	root = delete(root, key);	}
	
	/*
	* Remove a node with key k: search for node T containing key k. 
	* Three cases: Node has no child, Node has one child, 
	* Node has two children
	*/
	private Node delete(Node x, Key key)
	{
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = delete(x.left, key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else
		{	
			if(x.right == null) return x.left; 
			if(x.left == null) return x.right;
			// save link to node to be deleted in T
			// successor x: a value in x just greater than T
			// i.e. it's right subtree! 
			Node  t = x;
			// set x to point to its successor min(t.right)
			x = min(t.right);
			// Set the right link of x to deleteMin(t.right)
			x.right = deleteMin(t.right);
			// Set the left link of x (previously null) to 
			// All the elements that are less than both the
			// deleted key and its successor
			x.left = t.left;
			// return the node
		}
		// Update links and node counts after recursive calls
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	//!!!Successor of x is the node with the smallest key in its right subtree
	

	// TRAVERSAL ALGORITHMS FOR BinaryTree
	/*
	* Print the keys in a BinaryTree in order
	* logic: print all keys in left subtree
	* (which are less than key at root)
	* then print the key at root, then print
	* all the keys in right subtree (greater than key at root)
	*/
	private void printInOrderKey(Node x)
	{
		if (x == null) return;
		printInOrderKey(x.left);
		System.out.println(x.key + " ");
		printInOrderKey(x.right);
	}

	/*
	* Print the keys in a BinaryTree in pre-order
	*/
	private void printPreOrderKey(Node x)
	{
		System.out.println(x.key + " ");
		if(x.left != null)
			printPreOrderKey(x.left);
		if(x.right != null)
			printPreOrderKey(x.right);
	}

	/*
	* Print the keys in a BinaryTree in post-order
	* Can be used to solve expression tree evaluation problem
	*/
	private void printPostOrderKey(Node x)
	{
		// recursively begin with left child
		if(x.left != null)
			printPostOrderKey(x.left);
		if(x.right != null)
			printPostOrderKey(x.right);
		System.out.println(x.key + " ");
	}

	//inorder traversal using recursion
	private void inOrderTraverseTree(Node x)
	{
		if(x == null)
			return;
		inOrderTraverseTree(x.left);
		System.out.println(x.val + " has key " + x.key);
		inOrderTraverseTree(x.right);
	}

	//preorder traversal using recursion
	private void preOrderTraverseTree(Node x)
	{
		if (x==null)
			return;
		System.out.println(x.val + " has key " + x.key);
		preOrderTraverseTree(x.left);
		preOrderTraverseTree(x.right);

	}

	//postorder traversal using recursion
	private void postOrderTraverseTree(Node x)
	{
		if (x==null)
			return;
		postOrderTraverseTree(x.left);
		postOrderTraverseTree(x.right);
		System.out.println(x.val + " has key " + x.key);
	}

	public Node findNode(Key key)
	{
		return findNode(root, key);
	}

	//search!
	private Node findNode(Node x, Key key)
	{
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp<0) return findNode(x.left,key);
		else if (cmp>0) return findNode(x.right,key);
		else return x;
	}

	public static void main(String[] args) {
		BinaryTree<Integer, String> theTree = new BinaryTree<Integer, String>();
		theTree.put(50, "Boss");
		theTree.put(25,"Vice Pres");
		theTree.put(15,"Office Manager");
		theTree.put(30,"Secretary");
		theTree.put(75,"Sales Manager");
		theTree.put(85,"Salesman 1");
		theTree.postOrderTraverseTree(theTree.root);
		System.out.println("Search for 30");
		System.out.println(theTree.findNode(30).val);
	}

}