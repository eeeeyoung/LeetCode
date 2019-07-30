import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/.
 */
public class BinaryTreeZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root);
        recursiveZigZag(res, ll);
        return res;
    }

    private void recursiveZigZag(List<List<Integer>> res,
                                 LinkedList<TreeNode> ll) {
        if (ll.isEmpty()) return;
        List<Integer> thisLevel = new LinkedList<>();
        LinkedList<TreeNode> nextll = new LinkedList<>();

        if ((res.size() % 2) == 1) {
            // from left to right
            while (!ll.isEmpty()) {
                TreeNode temp = ll.removeFirst();
                thisLevel.add(temp.val);
                if (temp.right != null) nextll.addLast(temp.right);
                if (temp.left != null) nextll.addLast(temp.left);
            }

        } else {
            // from right to left, (res.size() % 2) == 0)
            while (!ll.isEmpty()) {
                TreeNode temp = ll.removeLast();
                thisLevel.add(temp.val);
                if (temp.left != null) nextll.addFirst(temp.left);
                if (temp.right != null) nextll.addFirst(temp.right);
            }
        }
        res.add(thisLevel);
        recursiveZigZag(res, nextll);
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
