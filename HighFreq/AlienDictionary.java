import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/alien-dictionary/.
 */
public class AlienDictionary {
    private final int N = 26;
    public String alienOrder(String[] words) {
        if (words == null) return "";
        HashSet<Character> hs;
        // uses HashMap to store paths from char1 to char2

        HashMap<Character, HashSet<Character>> paths = new HashMap<>();
        // constructing the paths
        for (int i = 0; i < words.length - 1; i ++) {
            String word = words[i];
            int fM = firstMismatch(word, words[i + 1]);
            if (fM  == word.length()) {
                // pass
            } else {
                if (paths.containsKey(word.charAt(fM))) {
                    hs = paths.get(word.charAt(fM));
                } else {
                    hs = new HashSet<>();
                }
                hs.add(words[i + 1].charAt(fM));
                paths.put(word.charAt(fM), hs);
            }
        }

        return "";
    }

    private int firstMismatch(String s1, String s2) {
        for (int a = 0; a < s1.length(); a++) {
            if (s1.charAt(a) != s2.charAt(a)) {
                return a;
            }
        }
        return s1.length();
    }
}
