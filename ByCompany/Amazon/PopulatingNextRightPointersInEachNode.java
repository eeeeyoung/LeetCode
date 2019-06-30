/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/.
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        Node realRoot = root;

        /* Using tempChild as a dummy node */
        Node tempChild = new Node(0, null, null, null);
        while (root != null) {
            Node currentChild = tempChild; // conserve the tempChild and use reference
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;  // root.left is currentChild now
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;  // root.right is currentChild now
                }
                root = root.next;  // going across, to another subtree
            }
            root = tempChild.next;
            tempChild.next = null;
        }
        return realRoot;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
