//Q2 2017
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class Deserializer {
	private class Node {
		Node left; Node right; char data;
		Node (int newData)
		{
			left = null;
			right = null;
			data = newData;
		}
	}
	// Node root;
	// Deserializer()
	// {
	// 	root = null;
	// }
	public String serialize(TreeNode root) {
	    ArrayList<String> list = new ArrayList<>();
	    LinkedList<TreeNode> q = new LinkedList<>();
	    q.offer(root);
	 
	    while (!q.isEmpty()) {
	        TreeNode h = q.poll();
	        if (h == null) {
	            list.add("$");
	        } else {
	            list.add("" + h.val);
	            q.offer(h.left);
	            q.offer(h.right);
	        }
	    }
	 
	    return String.join(",", list);
	}

	public void deSerialize()
	{
		this.root = deSerializeRecursive(list);
	}

	public Node deSerializeRecursive(ArrayList<String> list)
	{
		if (list.isEmpty())
			return null;
		//at node do some action
		int index = 0;
		if (index == 0)
			Node root  = new Node(Integer.parseInt(list.get(0)));
			index --;
		//recursively do left subtree
		root.left.deSerialize();
		//recursively do right subtree
		root.right.deSerialize();

		// base case
		if (root == null)
			return null;
		return root;
	}

	// test
	public static void main(String[] args) {
		String[] tree = new String[]{"2","4","$","$","1","7","10","$",
		"$","$","5","$","$"};
		List list = (List)Arrays.asList(tree);
		for(int i =0; i < list.size(); i++)
			list.get(i);
		deSerializeRecursive(list);
	}
}