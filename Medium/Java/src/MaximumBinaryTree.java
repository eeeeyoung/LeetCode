import jdk.nashorn.internal.runtime.Undefined;
import sun.reflect.generics.tree.Tree;

public class MaximumBinaryTree {

    private TreeNode root;

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        int maxIndex = maxFromArray(nums);
        int max = nums[maxIndex];
        root = new TreeNode(max);

        root.left = new TreeNode(nums[0]);

        for (int a = 1; a < maxIndex; a++) {
            insert(root.left, nums[a]);
        }

        root.right = new TreeNode(nums[maxIndex + 1]);

        for (int b = maxIndex + 2; b < nums.length; b++) {
            insert(root.right, nums[b]);
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxFromArray(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Recursive method for insertion, assuming no duplicates.
     * @param next The next node to consider, according to the format of a BST
     * @param val input value of the new node
     */
    private void insert(TreeNode next, int val) {
        if (val > next.val) {
            if (next.right == null) {
                next.right = new TreeNode(val);
            } else {
                insert(next.right, val);
            }
        } else {
            if (next.left == null) {
                next.left = new TreeNode(val);
            } else {
                insert(next.left, val);
            }
        }
    }
}
