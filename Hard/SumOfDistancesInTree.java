import java.util.*;

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/.
 */
public class SumOfDistancesInTree {
    int[] ans, count;
    List<Set<Integer>> graph;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<Set<Integer>>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    /**
     *
     * Solution from https://leetcode.com/problems/sum-of-distances-in-tree/solution/.
     * Root the tree. For each node, consider the subtree S_{\text{node}}S
     * node
     * ​
     *   of that node plus all descendants. Let count[node] be the number of nodes in S_{\text{node}}S
     * node
     * ​
     *  , and stsum[node] ("subtree sum") be the sum of the distances from node to the nodes in S_{\text{node}}S
     * node
     * ​
     *  .
     *
     * We can calculate count and stsum using a post-order traversal, where on exiting some node, the count and stsum of all descendants of this node is correct, and we now calculate count[node] += count[child] and stsum[node] += stsum[child] + count[child].
     *
     * This will give us the right answer for the root: ans[root] = stsum[root].
     *
     * Now, to use the insight explained previously: if we have a node parent and it's child child, then these are neighboring nodes, and so ans[child] = ans[parent] - count[child] + (N - count[child]). This is because there are count[child] nodes that are 1 easier to get to from child than parent, and N-count[child] nodes that are 1 harder to get to from child than parent.
     * @param node
     * @param parent
     */
    public void dfs2(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
    }
}
