import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/course-schedule-ii/.
 */
public class CourseScheduleII {

    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    // Topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] prerequisite : prerequisites) {
            ArrayList<Integer> temp = map.getOrDefault(prerequisite[1], new ArrayList<>());
            temp.add(prerequisite[0]);
            map.put(prerequisite[1], temp);
        }

        if (isCyclic(numCourses)) return new int[0];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }

        if (stack.size() < numCourses) return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private void topologicalSort(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;

        if (map.containsKey(i)) {
            for (Integer other : map.get(i)) {
                if (!visited[other]) {
                    topologicalSort(other, visited, stack);
                }
            }
        }

        stack.push(i);
    }

    private boolean isCyclic(int numCourses) {
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (cyclicUtility(visited, stack, i)) {
                return true;
            }
        }
        return false;
    }
    private boolean cyclicUtility(boolean[] visited, boolean[] stack, int i) {
        if (stack[i]) return true;
        if (visited[i]) return false;

        stack[i] = true;
        visited[i] = true;

        if (map.containsKey(i)) {
            for (Integer neighbor : map.get(i)) {
                if (cyclicUtility(visited, stack, neighbor)) {
                    return true;
                }
            }
        }

        // stack is released at the end of the search, which searched all child node of i's children,
        // and so on.
        stack[i] = false;
        return false;
    }
}
