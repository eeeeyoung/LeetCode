import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/word-ladder/.
 */
public class WordLadder {
    /**
     * First construct word relation graph
     * Then use BFS with visited marking to find the fastest path from source to sink
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int index = 0;
        if (!wordList.contains(beginWord)) {wordList.add(beginWord); index--;}
        int listLength = wordList.size();
        int[][] g = new int[listLength][listLength];
        int a;
        for (int i = 0; i < listLength; i++) {
            for (int j = i; j < listLength; j++) {
                if (i == j) { g[i][j] = 0; g[j][i] = 0; continue; }
                a = isStringNeighbor(wordList.get(i), wordList.get(j)) ? 1 : 0;
                g[i][j] = a;
                g[j][i] = a;
            }
        }
        System.out.println(g[0][1]);
        HashMap<String, WordNode> map = new HashMap<>();
        for (String word : wordList) {
            WordNode wn = new WordNode(word);
            map.put(word, wn);
        }
        // BFS
        List<String> prev = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        prev.add(beginWord);
        map.get(beginWord).visited = true;
        int depth = 0;
        while (!map.get(endWord).visited) {
            for (String w : prev) {
                index = wordList.indexOf(w);
                for (int i = 0; i < listLength; i++) {
                    if (g[index][i] == 1 && !map.get(wordList.get(i)).visited) {
                        curr.add(wordList.get(i));
                        map.get(wordList.get(i)).visited = true;
                    }
                }
            }
            prev = curr;
            curr = new ArrayList<>();
            depth++;
        }
        return depth + 1;
    }

    private static boolean isStringNeighbor(String a, String b) {
        int diff = 0;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }

    private static class WordNode {
        String word;
        boolean visited;
        WordNode(String k) {word = k; visited = false;}
    }
}
