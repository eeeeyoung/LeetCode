import sun.reflect.generics.tree.Tree;

/**
 * LeetCode: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/.
 * @author Yang YI
 */
public class BSTtoGreaterSumTree {

    private int lower = 0;

    public TreeNode bstToGst(TreeNode root) {
        int sum = sum(root);
        preorder(root, sum);
        return root;
    }

    private int sum(TreeNode root) {
        int r = 0;
        if (root != null) {
            r += sum(root.left);
            r += sum(root.right);
            r += root.val;
        }
        return r;
    }

    private void preorder(TreeNode root, int sum) {
        if (root != null) {
            preorder(root.left, sum);
            int t = root.val;
            root.val = sum - lower;
            lower += t;
            preorder(root.right, sum);
        }
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
