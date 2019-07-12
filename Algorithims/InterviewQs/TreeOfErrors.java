import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TreeOfErrors {
    static HashMap<String, Node> NodeHashmap;
    private static Node root;
    private static String data;
    static class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
        public boolean equals(Node other) {
        if (other == null ) return false;
    
        boolean valuesEqual = this.data == other.data;
    
        return valuesEqual;
        }
    }

    public static boolean isValid(String s) {
        if (Character.isWhitespace(s.charAt(0)))
            return false;
        else if (Character.isWhitespace(s.charAt(s.length() - 1)))
            return false;
        else
            return true;
    }

    // Helper
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

    static String stringToTree(String s) {
        if ((isValid(s)) == false) {
            return "E1";
        }
        Node root = new Node(s);
        int i = 0;
        root = insertTree(s, i);
        String res = GetHashString(root);
        return res;

    }

    public static Node insertTree(String s, int i) {
        // Base case for recursion
        Stack<Node> stack = new Stack<>();
        if (s == null || s.length() == 0)
            return null;
        Node x = new Node(s);
        i = 0;
        for (i = 0; i < s.length(); i++) {
            Node current = x;
            stack.push(current);
            if (s.substring(i, i + 1).contains("(")) {
                // next char is node
                i++;
                x = insertTree(s.substring(i, i + 1), i);
                if (current.equals(x)) current = x;
            }
            if (s.substring(i, i + 1).contains(",")) {
                i++;
                if (x.left == null) {
                    x.left = insertTree(s.substring(i, i + 1), i);
                } else if (x.right == null) {
                    x.right = new Node(s.substring(i + 1));
                    i++;
                } else {
                    return null;
                }
                // insert left child
            }
            current = stack.pop();
        }
        return x;
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String str = "";
        str += scanner.nextLine();
        scanner.close();
        String res = stringToTree(str);
        System.out.println(res);
    }
}