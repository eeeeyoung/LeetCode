/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/.
 */
public class MaximumDepthOfBinaryTree {

    private static int maxDepth;

    /**
     * Performs DFS, uses static int to store maxDepth
     * @param root the starting node "root"
     * @return the max depth
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        maxDepth = 0;
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > maxDepth) {
            maxDepth = level;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        return;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
