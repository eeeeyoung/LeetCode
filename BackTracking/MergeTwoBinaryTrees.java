/**
 * https://leetcode.com/problems/merge-two-binary-trees/.
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return recurMerge(t1, t2);
    }

    private TreeNode recurMerge(TreeNode nodeX, TreeNode nodeY) {
        TreeNode nodeZ;

        // determine the value of nodeZ
        if (nodeX != null && nodeY != null) {
            nodeZ = new TreeNode(nodeX.val + nodeY.val);
            nodeZ.left = recurMerge(nodeX.left, nodeY.left);
            nodeZ.right = recurMerge(nodeX.right, nodeY.right);
            return nodeZ;

        } else if (nodeX != null) {
            nodeZ = new TreeNode(nodeX.val);
            nodeZ.left = recurMerge(nodeX.left, null);
            nodeZ.left = recurMerge(nodeX.right, null);
            return nodeZ;
        } else if (nodeY != null) {
            nodeZ = new TreeNode(nodeY.val);
            nodeZ.right = recurMerge(nodeY.right, null);
            nodeZ.right = recurMerge(nodeY.right, null);
            return nodeZ;
        } else {
            return null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
