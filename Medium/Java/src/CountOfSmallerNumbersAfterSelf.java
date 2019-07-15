import java.util.*;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/.
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    /**
     * Helper Function for building the Binary Search Tree.
     *
     * case1: root is null, put (num, 0)
     *
     * case2: encountered node with identical value as num:
     *        -> increase the dup count of node
     *
     * case3: encountered node with val greater than num:
     *        -> increase the node's sum count by one while passing by
     *        -> recursively insert the new node to current node's left
     *
     * case4: encountered node with val smaller than num:
     *        -> add to CUMULATIVE SUM: node's sum: the number of numbers smaller than this node
     *        -> add to CUMULATIVE SUM: node's dup: the number of duplications in this node
     *        -> recursively insert the new node to current node's right
     * @param num the number to be inserted
     * @param node the current node visiting
     * @param ans the answer Integer array
     * @param i index in the Integer array
     * @param preSum THE CUMULATIVE sum starting from the root
     * @return return node to recursively build tree
     */
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

    class Node {
        Node left, right;
        int val, sum, dup = 1;

        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
}
