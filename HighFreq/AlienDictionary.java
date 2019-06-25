import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/alien-dictionary/.
 */
public class AlienDictionary {
    private HashMap<Character, HashSet<Character>> paths;
    public String alienOrder(String[] words) {
        if (words == null) return "";
        HashSet<Character> hs;
        // uses HashMap to store paths from char1 to char2

        paths = new HashMap<>();
        // constructing the paths
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            int fM = firstMismatch(word, words[i + 1]);
            for (Character c : word.toCharArray()) {
                if (!paths.containsKey(c)) paths.put(c, new HashSet<>());
            }
            if (fM  == word.length()) {
                //
            } else {
                if (paths.containsKey(word.charAt(fM))) {
                    hs = paths.get(word.charAt(fM));
                } else {
                    hs = new HashSet<>();
                }
                if (word.charAt(fM) != words[i + 1].charAt(fM)) {
                    hs.add(words[i + 1].charAt(fM));
                }
                paths.put(word.charAt(fM), hs);
            }
        }
        // Put in the last word
        for (Character c : words[words.length - 1].toCharArray()) {
            if (!paths.containsKey(c)) paths.put(c, new HashSet<>());
        }
        if (isCyclic()) {
            return "";
        } else {
            StringBuilder sb = topologicalSort();
            for (Character c : paths.keySet()) {
                if (sb.indexOf(c.toString()) == -1) sb.append(c);
            }
            return sb.toString();
        }
    }

    private int firstMismatch(String s1, String s2) {
        for (int a = 0; a < s1.length(); a++) {
            if (s1.charAt(a) != s2.charAt(a)) {
                return a;
            }
        }
        return s1.length();
    }

    private StringBuilder topologicalSort() {
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[256];
        for (Character c : paths.keySet()) {
            if (!visited[c]) topologicalSortUtility(c, visited, stack);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb;
    }

    private void topologicalSortUtility(Character c, boolean[] visited, Stack<Character> stack) {
        visited[c] = true;
        HashSet<Character> charSet = paths.get(c);
        if (charSet != null && !charSet.isEmpty()) {
            for (Character character : charSet) {
                if (!visited[character]) {
                    topologicalSortUtility(character, visited, stack);
                }
            }
        }
        stack.push(c);
        System.out.println(stack.size());
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[256];
        boolean[] stack = new boolean[256];
        for (Character c : paths.keySet()) {
            if (cyclicUtility(visited, stack, c)) {
                return true;
            }
        }
        return false;
    }
    private boolean cyclicUtility(boolean[] visited, boolean[] stack, Character i) {
        if (stack[i]) return true;
        if (visited[i]) return false;

        stack[i] = true;
        visited[i] = true;
        HashSet<Character> charSet = paths.get(i);
        if (charSet != null && !charSet.isEmpty()) {
            for (Character neighbor : charSet) {
                if (cyclicUtility(visited, stack, neighbor)) {
                    return true;
                }
            }
        }
        stack[i] = false;
        return false;
    }
}
