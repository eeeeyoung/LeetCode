/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/.
 */
public class PopulatingNextRightPointersInEachNode {
    /**
     * At each level, keeps track of :
     * root : the root of subtrees at the previous level, uses root.next to traverse
     * children : use currentChildren.next to traverse
     *
     * At termination of each level, use tempChild stored previously to restore
     * @param root reference to the input root
     * @return reference to the input root
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Node realRoot = root;

        /* Using tempChild as a dummy node */
        Node tempChild = new Node(0, null, null, null);
        while (root != null) {
            Node currentChild = tempChild;
            while (root != null) {  // root = root.next, the other root node across the other tree
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
            // In the inner while loop above, first call to currentChild.next, currentChild still
            // stores the reference to tempChild. Before changing the reference for the first time,
            // currentChild = tempChild.next is set to the first available child node
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
