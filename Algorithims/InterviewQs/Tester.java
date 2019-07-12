//iterative method for reversing a list
public static Node reverse(Node node)
{
	if(node == null || node.next == null) 
	{
		return node;
	}
	Node next = null;
	Node prev = null;
	Node current = node;
	//else
	while(current !=null)
	{
		next = current.next;
		current.next = prev;
		prev = current;
		current = next;
	}
	node = prev;
	return node;
}
//recursive method for reversing a list
public static Node reverse(Node current, Node prev)
{
	//base case
	if(current.next == null)
	{
		head = current;
		current.next = prev;
		return head;
	}
	//else general
	Node next = current.next;
	current.next = prev;
	//recursively reverse the next nodes
	reverse(next, current);
	return head;
}
//access  middle of l list
public Node middle(int index)
{
	if(head == null || head.next == null){ return head; }
	//create two pointers; one fast, one slow
	Node fastPtr = head;
	Node slowPtr = head;
	while(fastPtr!= null && fastPtr.next!=null)
	{
		fastPtr = fastPtr.next.next;
		slowPtr = slowPtr.next;
	}
	return slowPtr;
}
//find disappearing integers from a list
public List<Integer> findDisappearedNums(int[]nums)
{
	List<Integer> res = new List<Integer>();
	//travel the array and mark numbers visited as negative
	for(int no: nums)
	{
		int i = Math.abs(no)-1;
		if(nums[i]>0)
			//mark as neg
			nums[i]=-nums[i];
	}
	//travel again and if unmarked i.e. = positive i.e. disappearing add to list
	for (int i=0;i<nums.length;i++) {
		if(nums[i]>0)
		{
			res.add(i+1);
		}
	}
	return res;
}


