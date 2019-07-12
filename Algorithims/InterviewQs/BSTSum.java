/*package InterviewQs;
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
/**
 * BSTSum
 */
import java.util.*;
public class BSTSum {
    public static TreeNode root;
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {  val =x; }
    }
    
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    public boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null)
            return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null)
            return false;
        return (root.val == value) && (root != cur) || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }


    /*
        Something different using a sorted array via inorder traversal 
        Use two pointers one at beg one at end and see if each respective index sums to k
    */
    public boolean somethingDifferent(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j;) {
            if (nums.get(i) + nums.get(j) == k)
                return true;
            if (nums.get(i) + nums.get(j) < k)
                i++;
            else
                j--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null)
            return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
    
    public static void main(String[] args) {
        BSTSum s = new BSTSum();
        TreeNode rooty = new TreeNode(2);
        rooty.left = new TreeNode(1);
        rooty.right = new TreeNode(3);
        rooty.left.left = new TreeNode(4);
        rooty.left.right = new TreeNode(5);
        rooty.right.left = new TreeNode(6);
        rooty.right.right = new TreeNode(7);
        int k = 3;
        System.out.println(s.findTarget(rooty, k));
    }    
}