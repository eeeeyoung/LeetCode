import java.util.*;

public class CourseScheduleSelf {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create list to store edges
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for (int a = 0; a < numCourses; a++) {
            edges.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> edge = edges.get(prerequisites[i][0]);
            edge.add(prerequisites[i][1]);
        }

        return !isCyclic(numCourses, edges);
    }
    private boolean isCyclic(int numCourses, List<List<Integer>> edges) {
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (cyclicUtility(edges, visited, stack, i)) {
                return true;
            }
        }
        return false;
    }
    private boolean cyclicUtility(List<List<Integer>> edges,
                                  boolean[] visited, boolean[] stack, int i) {
        if (stack[i]) return true;
        if (visited[i]) return false;

        stack[i] = true;
        visited[i] = true;

        for (Integer neighbor : edges.get(i)) {
            if (cyclicUtility(edges, visited, stack, neighbor)) {
                return true;
            }
        }
        stack[i] = false;
        return false;
    }
}
