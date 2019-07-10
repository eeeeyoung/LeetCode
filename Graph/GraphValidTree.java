import java.util.Arrays;

/**
 * https://leetcode.com/problems/graph-valid-tree/.
 */
public class GraphValidTree {
    /**
     * Making use of the union find algorithm.
     * @param n the number of nodes in the graph
     * @param edges both vertices of the undirected edge
     * @return isValidTree
     */
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for (int[] edge : edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);

            if (x == y) return false;

            edge[x] = y;
        }
        return edges.length == n - 1;
    }

    private int find(int[] nums, int i) {
        if (nums[i] == -1) return -1;
        return find(nums, nums[i]);
    }
}
