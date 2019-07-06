//Q2 2017
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
	Node root;
	Deserializer()
	{
		root = null;
	}

	public void deSerialize()
	{
		this.root = 
	}

	public Node deSerialiseRecursive(ArrayList<String> list)
	{
		// base case
		if (list.isEmpty())
			return;
		//at node do some action

		//recursively do left subtree
		
		//recursively do right subtree
	}
}