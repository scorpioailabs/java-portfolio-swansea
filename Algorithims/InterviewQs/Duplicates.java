/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
public class Duplicates {
	public List<Integer> findDuplicates(int[]nums)
	{
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<nums.length;i++) {
			if(map.get(nums[i])!=null)
			{
				res.add(nums[i]);
			}
			map.put(nums[i], i);
		}
		return res;
	}

	// use Math.abs so that we can mark visited elements as negative
	public List<Integer> somethingBetter(int[]nums)
	{
		List<Integer> res = new ArrayList<Integer>();
		if(nums==null || nums.length==0) return res;
		for (int i=0; i<nums.length;i++) {
			int index = (Math.abs(nums[i]));
			if(nums[index-1] < 0)
			{
				//this has been already marked as negative therefore == duplicate
				res.add(index);
			}
			else
			{
				//if unseen mark as negative i.e. visited
				nums[index-1] = -nums[index-1];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] a = {4,3,2,7,8,2,3,1};

	}
}