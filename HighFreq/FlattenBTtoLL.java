/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/.
 */
public class FlattenBTtoLL {
    public void flatten(TreeNode root) {
        flattenLeft(root);
    }

    private TreeNode flattenLeft(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode tempRight = node.right;  // could be null

        node.right = flattenLeft(node.left);
        node.left = null;
        TreeNode next = node;
        while (next.right != null) {
            next = next.right;  // at the end, next.right is null
        }
        next.right = flattenLeft(tempRight);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
