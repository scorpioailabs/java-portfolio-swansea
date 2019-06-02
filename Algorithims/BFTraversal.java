// Breadth-first traversal of a binary tree i.e. level-by-level
/*											  1	
*                                            / \
											/   \
										   /	 \
										  2		  3
										 / \ 
										/	\
									   /	 \
									  4		  5
*/
class Node 
{
	int key;
	Node left, right;

	Node(int data) 
	{
		data = key;
		left = right = null;
	}
}

public class BFTraversal {
	// Root of Binary Tree
	Node root;
	// Constructor
	public BFTraversal()
	{
		root = null;
	}

	/* Compute "height" of a tree
	i.e. the number of nodes along the 
	longest path from root to farthest
	leaf node. */
	int height(Node root)
	{
		if(root == null)
			return 0;
		else
		{
			/* recursively compute height of each subtree */
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);

			/* use the larger one */
			if(leftHeight > rightHeight)
				return(leftHeight+1);
			else return(rightHeight+1);
		}
	}

	/*Print nodes at the given level */
	void printLevel (Node root, int level) 
	{
		if(root == null)
			return;
		if(level == 1)
			System.out.println(root.key + " ");
		else if(level > 1)
		{
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}

	public static void main(String[] args)  
	{ 
	    // Let us create binary tree shown in above diagram 
	   /*               1 
	               /     \ 
	              2       3 
	            /   \       \ 
	           4     5       6 
	    */
	    DFTraversal tree = new DFTraversal();
	    Node root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5); 
	    tree.root.right.right = new Node(6);

	} 
}