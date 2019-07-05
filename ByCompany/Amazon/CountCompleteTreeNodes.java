/**
 * https://leetcode.com/problems/count-complete-tree-nodes/.
 */
public class CountCompleteTreeNodes {
    // use recursion to look for the first null in the leftest child node
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = countDepth(root);
        if (depth == 1) return 1;

        // perform binary search on the deepest level nodes
        int left = 0;
        int right = (int)Math.pow(2, depth) - 1;

        while (left != right) {
            int mid = left + (right - left) / 2;
            if (nodeExists(root, depth, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int res = (int)Math.pow(2, depth) + left - 1;
        if (nodeExists(root, depth, left)) {
            res++;
        }
        return res;
    }

    private int countDepth(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            // leftest node is guaranteed to be populated
            node = node.left;
            depth++;
        }
        return depth;
    }

    private boolean nodeExists(TreeNode node, int depth, int lastRowIndex) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;

        for (int i = 0; i < depth - 1; i++) {
            int mid = left + (right - left) / 2;
            if (lastRowIndex > mid) {
                node = node.right;
                left = mid + 1;
            } else {
                node = node.left;
                right = mid;
            }
        }
        return node != null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
