/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

*/
public class LowestCommonAncestor {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode myLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaSearch(root, p, q);
    }

    private TreeNode lcaSearch(TreeNode root, TreeNode p, TreeNode q) {
        // base cases
        if(root==null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode leftSearch = lcaSearch(root.left, p, q);
        TreeNode rightSearch = lcaSearch(root.right, p, q);
        if (leftSearch == null)
            return rightSearch;
        if (rightSearch == null)
            return leftSearch;
        else
            return root;
    }
    //Something Simpler! 4 lines of code: Same speed though.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
        return (leftSearch != null && rightSearch != null) ? root : (leftSearch != null ? leftSearch : rightSearch);
    }
}



