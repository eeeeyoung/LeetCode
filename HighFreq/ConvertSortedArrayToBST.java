/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/.
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        // recursively construct a tree
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursiveBST(0, mid, nums);
        root.right = recursiveBST(mid + 1, nums.length, nums);
        return root;
    }

    private TreeNode recursiveBST(int leftBound, int rightBound, int[] nums) {
        if (leftBound == rightBound) {
            return null;
        }
        int mid = leftBound + (rightBound - leftBound) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = recursiveBST(leftBound, mid, nums);
        newNode.right = recursiveBST(mid + 1, rightBound, nums);
        return newNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
