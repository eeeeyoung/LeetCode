import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBSTII {

    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        return recursiveHelper(nums);
    }

    private List<TreeNode> recursiveHelper(int[] availables) {
        List<TreeNode> leftRes, rightRes, finalRes;
        int arrlen = availables.length;
        if (arrlen <= 1) {
            leftRes = new ArrayList<>();
            if (arrlen == 0) return leftRes;
            leftRes.add(new TreeNode(availables[0]));
            return leftRes;
        }

        finalRes = new ArrayList<>();
        for (int mid = 0; mid < arrlen; mid++) {
            int[] left = Arrays.copyOfRange(availables, 0, mid);
            int[] right = Arrays.copyOfRange(availables, mid + 1, arrlen);

            if (left.length == 0) {
                leftRes = new ArrayList<>();
            } else {
                leftRes = recursiveHelper(left);
            }
            if (right.length == 0) {
                rightRes = new ArrayList<>();
            } else {
                rightRes = recursiveHelper(right);
            }

            finalRes.addAll(gatherResults(leftRes, rightRes, availables[mid]));
        }
        return finalRes;
    }

    private List<TreeNode> gatherResults(List<TreeNode> l, List<TreeNode> r,
                                         int mid) {
        List<TreeNode> res = new ArrayList<>();
        if (l.size() == 0) {
            for (TreeNode right : r) {
                TreeNode newHead = new TreeNode(mid);
                newHead.right = right;
                newHead.left = null;
                res.add(newHead);
            }
        } else if (r.size() == 0) {
            for (TreeNode left : l) {
                TreeNode newHead = new TreeNode(mid);
                newHead.right = null;
                newHead.left = left;
                res.add(newHead);
            }
        } else {
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode newHead = new TreeNode(mid);
                    newHead.left = left;
                    newHead.right = right;
                    res.add(newHead);
                }
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
