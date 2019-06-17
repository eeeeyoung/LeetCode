/**
 * https://leetcode.com/problems/unique-binary-search-trees/.
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class DPUniqueBinarySearchTrees {
    /**
     * Note: Only structurally identical.
     * @param n the number of nodes
     * @return number of structurally unique trees
     */
    public int numTrees(int n) {
        // init
        int[] counts = new int[n + 1];
        int temp;

        // base case
        counts[0] = 1;
        counts[1] = 1;

        // Recursion
        for (int i = 2; i <= n; i++) {
            temp = 0;
            for (int j = 1; j <= i; j++) {
                temp += (counts[j - 1] * counts[i - j]);
            }
            counts[i] = temp;
        }
        return counts[n];
    }
}
