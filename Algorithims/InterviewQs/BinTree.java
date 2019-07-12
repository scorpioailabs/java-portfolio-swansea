import java.util.HashMap; //import function for Hashmap
import java.util.PriorityQueue;
import java.util.Queue;

public class BinTree {
    static Node root;
    public static boolean flag = false;

    // this is creating a 2D hashmap of hashes stored as strings and references to
    // nodes
    static HashMap<String, Node> NodeHashmap;

    // simple linked list for the binary search tree
    static class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    

    // returns a unique hash for a single node taking into account all of its
    // children and their data
    // divide and conquer (recursive code) will call itself multiple times the whole
    // length of the tree before
    // returning a single value string
    static String GetHashString(Node node) {
        if (node == null)
            return "";

        String str = "(";
        str += (node.data);
        str += GetHashString(node.left);
        str += GetHashString(node.right);
        str += ")";

        return str;
    }

    // Checks to see if a node already exists on the Hashmap.
    // if it exists replaces with a pre-existing node already from the Hashmap
    // otherwise insert into the Hashmap.
    // This divide and conquer algorithm is set up to make sure that the lowest
    // level nodes
    // are computated first so that the hashes of the higher nodes are not incorrect
    static Node ifExistsReplaceOrElseInsert(Node node) {
        if (node == null)
            return null;

        Node NodeLeftTemp = ifExistsReplaceOrElseInsert(node.left);
        if (NodeLeftTemp != null) {
            node.left = NodeLeftTemp;
        }
        Node NodeRightTemp = ifExistsReplaceOrElseInsert(node.right);
        if (NodeRightTemp != null) {
            node.right = NodeRightTemp;
        }

        String str = GetHashString(node);

        if (NodeHashmap.containsKey(str)) { // containsKey checks if the data string exists
            System.out.println("match Found node, Value:" + node.data + " Hash:" + str);
            return NodeHashmap.get(str); // get collects the corresponding node
            // As the parent node is the one that needs to have the replacement reference to
            // the pre-existing
            // binary subtree, the reference is returned to the parent and then used to
            // replace the relevant node
        } else {
            NodeHashmap.put(str, node);
        }

        return null;
    }

    private void printInOrderKey(Node x) {
        if (x == null)
            return;
        printInOrderKey(x.left);
        System.out.println(x.data + " ");
        printInOrderKey(x.right);
    }

    /*
     * Print the keys in a BST in pre-order
     */
    private void printPreOrderKey(Node x) {
        System.out.println(x.data + " ");
        if (x.left != null)
            printPreOrderKey(x.left);
        if (x.right != null)
            printPreOrderKey(x.right);
    }

    /*
     * Print the keys in a BST in post-order Can be used to solve expression tree
     * evaluation problem
     */
    private void printPostOrderKey(Node x) {
        // recursively begin with left child
        if (x.left != null)
            printPostOrderKey(x.left);
        if (x.right != null)
            printPostOrderKey(x.right);
        System.out.println(x.data + " ");
    }

    // Function to insert nodes in level order
    public static Node insertLevelOrder(String s, int i) {
        // Base case for recursion
        if (s == null || s.length() == 0)
            return null;
        Node x = new Node(s);
        i = 0;
        String testy = s.substring(1);
        for (i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).contains("(")) {
                // next char is node
                i++;
                x = insertLevelOrder(s.substring(i, i + 1), i);
            }
            if (s.substring(i, i + 1).contains(",")) {
                i++;
                if (x.left == null) {
                    x.left = insertLevelOrder(s.substring(i, i + 1), i);
                } else if (x.right == null) {
                    x.right = new Node(s.substring(i + 1));
                    i++;
                } else {
                    return null;
                }
                // insert left child
            }

        }
        return x;
    }

    public static String str2Tree(String s) {
        Node root = new Node(s);
        int i = 0;
        root = insertLevelOrder(s, i);
        String res = GetHashString(root);
        return res;
    }

    // Function to print tree nodes in InOrder fashion
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String args[]) {
        BinTree b = new BinTree();
        NodeHashmap = new HashMap<>();
        String s = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        s = str2Tree(s);
        System.out.println(s);
        // Node[] roots = new Node[3];
        // roots[0] = new Node(3);
        // roots[0].left = new Node(2);
        // roots[0].left.left = new Node(1);
        // roots[0].left.left.left = new Node(0);

        // System.out.println("insert Tree 1");
        // ifExistsReplaceOrElseInsert(roots[0]);

        // roots[1] = new Node(1);
        // roots[1].left = new Node(2);
        // roots[1].left.left = new Node(3);
        // roots[1].left.right = new Node(4);
        // roots[1].right = new Node(5);

        // System.out.println("insert Tree 2");
        // ifExistsReplaceOrElseInsert(roots[1]);

        // roots[2] = new Node(2);
        // roots[2].left = new Node(1);
        // roots[2].left.left = new Node(0);
        // roots[2].right = new Node(5);
        // roots[2].right.left = new Node(3);
        // roots[2].right.right = new Node(7);

        // System.out.println("insert Tree 3");
        // ifExistsReplaceOrElseInsert(roots[2]);

        // Node rooty = new Node(1);
        // rooty.left = new Node(2);
        // rooty.right = new Node(3);
        // rooty.left.left = new Node(4);
        // rooty.left.left.left = new Node(5);
        // rooty.right.left = new Node(6);
        // rooty.left.left.left.left = new Node(7);
        // String mag = GetHashString(rooty);

        // System.out.println("insert Tree 3");

        // System.out.println("insert Tree 2");


        // int[] arr = {1,2,4,5,7,3,6};
        // System.out.println("done");
        // // b.printPreOrderKey(roots[1]);
        // int i =0;
        // root = insertLevelOrder(arr, root, i);
        // inOrder(root);
        // System.out.println(mag);
    }
}