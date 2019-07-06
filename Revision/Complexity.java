//Complexity analysis
public class Complexity {
	public void deleteAt(int index)
	{
		if (index == 0)
		{
			head = head.next;
		}
		else 
		{
			Node tNode = head;
			Node n1 = null;
			int i = 1;
			for (int i = 1; i < index; i++)
			//C1 takes n time where n is the number of iterations from 1 --> index
			{
				tNode = tNode.next;
				i++;
			}
			n1 = tNode.next;
			tNode.next = n1.next;
		} 
	}

	oneDeleteAt(Node tNode)
	{
		tNode.val = tNode.next.val;
		tNode.next = tNode.next.next;
	}
}