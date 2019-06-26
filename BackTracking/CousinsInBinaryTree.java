import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/.
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) isAexist = true;
                if (cur.val == y) isBexist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) {
                        return false;
                    }
                    if (cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
