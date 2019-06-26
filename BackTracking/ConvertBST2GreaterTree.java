/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/.
 */
public class ConvertBST2GreaterTree {
    /**
     * Core idea is to use post-order traversal and pass back the added value
     * @param root input node
     * @return modified tree's root
     */
    public TreeNode convertBST(TreeNode root) {
        postOrder(root, 0);
        return root;
    }

    private int postOrder(TreeNode node, int cumSum) {
        if (node == null) return cumSum;
        int passBack = postOrder(node.right, cumSum);
        node.val = passBack + node.val;
        return postOrder(node.left, node.val);
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
