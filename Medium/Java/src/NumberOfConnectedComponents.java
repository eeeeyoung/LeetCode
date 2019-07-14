import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/.
 */
public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) uf[i] = i;

        for (int[] edge : edges) {
            int a = find(uf, edge[0]);
            int b = find(uf, edge[1]);

            if (a != b) {
                uf[a] = b;
                n--;
            }
        }

        return n;
    }

    private int find(int[] uf, int id) {
        while (uf[id] != id) {
            uf[id] = uf[uf[id]];  // optional path compression
            id = uf[id];
        }
        return id;
    }
}
