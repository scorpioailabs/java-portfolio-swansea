// A program for Tree Traversal, depth first: preorder, postorder, inorder.
// Breadth first: 
class Node {
	int key;
	Node left, right;
	Node(int data)
	{
		key = data;
		left = right = null;
	}
}
public class DFTraversal {
	// Root of Binary Tree
	Node root;
	TreeTraversal()
	{
		root = null;
	}

	/* given a binary tree, print its nodes according to
	 preorder traversal. */

	void printPreOrder(Node node)
	{
		if(node == null)
			return;
		// Begin with node 
		System.out.println(node.key + " ");

		// recur on left sub-tree
		printPreOrder(node.left);

		// recur on right subtree
		printPreOrder(node.right);
	}

	/* given a binary tree, print its nodes according to
	postorder traversal. */
	void printPostOrder(Node node) 
	{
		if(node == null)
			return;
		// start with bottom up therefore start with subtree
		printPostOrder(node.left);
		// recur on right subtree
		printPostOrder(node.right);
		// now deal with node
		System.out.println(node.key + " ");
	}

	/*given a binary tree, print its nodes inorder */
	void printInOrder(Node node)
	{
		if(node == null)
			return;
		// first recur on left child
		printInOrder(node.left);
		// then print data of node
		System.out.println(node.key + " ");
		// then recur on right child
		printInOrder(node.right);
	}

	// Wrappers over above recursive functions
	void printPreOrder() {		printPreOrder(root);	}
	void printPostOrder() {		printPostOrder(root);	}
	void printInOrder() {		printInOrder(root);		}

	// Driver method
	public static void main(String[] args) {
		DFTraversal tree = new DFTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is: ");
		tree.printPreOrder();
		System.out.println("Postorder traversal of binary tree is: ");
		tree.printPostOrder();
		System.out.println("Inorder traversal of binary tree is: ");
		tree.printInOrder(); 
	}
}


