import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/is-graph-bipartite/.
 */
public class IsGraphBipartite {
    // dfs and coloring
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        color[0] = 0;

        // sets 0 as dfs source
        return dfs(color, graph, 0, 1);  // root's color is set to 0, hardcode pc = 1 to satisfy
    }

    private boolean dfs(int[] color, int[][] graph, int index, int parentColor) {
        if (color[index] == parentColor) return false;
        if (color[index] == -1) color[index] = parentColor == 0 ? 1 : 0;

        Stack<Integer> nei = new Stack<>();
        for (int i : graph[index]) nei.push(i);
        while (!nei.isEmpty()) {
            int next = nei.pop();
            if (color[next] == -1) {
                if (!dfs(color, graph, next, color[index])) {
                    return false;
                }
            } else {
                if (color[next] != parentColor) {
                    return false;
                }
            }
        }

        return true;
    }
}
