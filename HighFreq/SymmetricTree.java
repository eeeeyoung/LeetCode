/**
 * https://leetcode.com/problems/symmetric-tree/solution/.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val == t2.val) {
            return isMirror(t1.left, t2.right)
                    && isMirror(t1.right, t2.left);
        } else {
            return false;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
