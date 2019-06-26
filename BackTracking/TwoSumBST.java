import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/.
 */
public class TwoSumBST {

    public boolean findTarget(TreeNode root, int k) {
        // dfs, in-order traversal
        List<Integer> flat = new ArrayList<>();
        inorder(root, flat);
        int i = 0, j = flat.size()-1;

        // 2 pointer recursion to find sum in sorted array
        while (i < j) {
            int sum = flat.get(i) + flat.get(j);
            if (sum == k) return true;
            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
