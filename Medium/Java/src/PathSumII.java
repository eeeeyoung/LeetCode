import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    List<Integer> temp = new LinkedList<>();
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) return res;
        recurPathSum(root, sum);
        return res;
    }

    private void recurPathSum(TreeNode node, int sum) {
        if (sum == node.val && node.left == null && node.right == null) {
            List<Integer> newRes = new ArrayList<>();
            for (int i : temp) {newRes.add(i);}
            newRes.add(node.val);
            res.add(newRes);
        }

        temp.add(node.val);
        if (node.left != null) {
            recurPathSum(node.left, sum - node.val);
        }

        if (node.right != null) {
            recurPathSum(node.right, sum - node.val);
        }
        temp.remove(temp.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
