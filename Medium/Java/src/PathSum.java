public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        // base case
        if (root == null) return false;

        if (root.left != null && root.right != null) {
            return hasPathSum(root.left, sum - root.val) ||
                    hasPathSum(root.right, sum - root.val);
        }

        if (root.left != null) {
            return hasPathSum(root.left, sum - root.val);
        }

        if (root.right != null) {
            return hasPathSum(root.right, sum - root.val);
        }

        // control shall not reach here
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
