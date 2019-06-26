/**
 * https://leetcode.com/problems/invert-binary-tree/.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;
        invert(node.right);
        invert(node.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
