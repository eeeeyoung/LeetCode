/**
 * https://leetcode.com/problems/range-sum-of-bst/.
 */
public class RangeSumOfBST {

    private int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        sum = 0;
        recursion(root, L, R);
        return sum;
    }

    private void recursion(TreeNode node, int L, int R) {
        if (node == null) return;
        if (node.val <= R && node.val >= L) sum += node.val;
        recursion(node.left, L, R);
        recursion(node.right, L, R);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
