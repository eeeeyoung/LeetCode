import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/.
 */
public class BinaryTreeInorderTraversal {
    /**
     * Solution constructed using morris traversal.
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {  // previous while ended with pre.right == null
                    pre.right = cur;      // finds an empty place to store cur, which is the
                                          // current root

                    cur = cur.left;       // move current root to the root's left node
                } else {
                    pre.right = null;     // previous while ended with pre.right == cur
                    nodes.add(cur.val);
                    cur = cur.right;
                }
            } else {
                nodes.add(cur.val);       // current root's left node is null, can add val of cur
                cur = cur.right;          // proceed to change root to cur.right
            }
        }
        return nodes;
    }
}
