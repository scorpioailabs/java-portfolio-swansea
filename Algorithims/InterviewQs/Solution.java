/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
    public class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }
    }
    private int i = 0; // make i global

    public TreeNode str2tree(String s) {
        if (s.equals(""))
            return null;

        return dfs(s);
    }

    private void printPostOrderKey(TreeNode x) {
        if (x.left != null)
            printPostOrderKey(x.left);
        if (x.right != null)
            printPostOrderKey(x.right);
        System.out.println(x.val + " ");
    }

    private TreeNode dfs(String str) {
        TreeNode root = null;
        TreeNode childNode = null, rightNode = null;
        for (int i =0; i < str.length(); i++)
            if (str.charAt(i) == '(') {
            root = new TreeNode(str.charAt(i+1));
            if (str.charAt(i) == ',') {
                childNode = dfs(str);
            } // for the possible leftNode, if '(' met.
        }
        // if not '(' it must be ')' or i==s.length()
        // so we return the current stack
        root.left = childNode;
        root.right = childNode;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "(1,3)(2,5)(3,5)";
        TreeNode root = s.str2tree(str);
        s.printPostOrderKey(root);
    }
}