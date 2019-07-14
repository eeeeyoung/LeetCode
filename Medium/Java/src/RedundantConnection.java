import java.util.HashSet;

/**
 * https://leetcode.com/problems/redundant-connection/.
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] unionFind = new int[edges.length + 1];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }

        for (int[] edge : edges) {
            int a = find(unionFind, edge[0]);
            int b = find(unionFind, edge[1]);

            if (a != b) {
                unionFind[a] = b;
            } else {
                return edge;
            }
        }
        return null;
    }

    private int find(int[] uf, int id) {
        while (uf[id] != id) {
            id = uf[id];
        }
        return id;
    }
}
