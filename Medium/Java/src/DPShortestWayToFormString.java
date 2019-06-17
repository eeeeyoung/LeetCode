import java.util.HashSet;

/**
 * https://leetcode.com/problems/shortest-way-to-form-string/.
 *
 * From any string, we can form a subsequence of that string
 * by deleting some number of characters (possibly no deletions).
 *
 * Given two strings source and target,
 * return the minimum number of subsequences of source such that their concatenation equals target.
 * If the task is impossible, return -1.
 */
public class DPShortestWayToFormString {

    public int shortestWay(String source, String target) {
        int count = 1;

        if (!isDoable(source, target)) {
            return -1;
        }

        // Looping through every character of target
        int ptr = -1;
        for (int pos = 0; pos < target.length(); pos++) {
            ptr = source.indexOf(target.charAt(pos), ptr + 1);

            if (ptr == -1) {
                count++;
                ptr = source.indexOf(target.charAt(pos), 0);
            }
        }

        return count;
    }

    private boolean isDoable(String s, String t) {
        HashSet<Integer> src = new HashSet<>();
        HashSet<Integer> tgr = new HashSet<>();

        for (char c : s.toCharArray()) {
            src.add((int) c);
        }

        for (char c: t.toCharArray()) {
            tgr.add((int) c);
        }
        // Checking for each char in source, if there is at least one to one mapping in target
        for (Integer i : tgr) {
            if (!src.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
