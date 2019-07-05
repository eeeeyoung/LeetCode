import java.util.TreeMap;

/**
 * https://leetcode.com/problems/odd-even-jump/.
 */
public class OddEvenJump {
    /**
     * You may from index i jump forward to index j (with i < j) in the following way:
     *
     * During odd numbered jumps (ie. jumps 1, 3, 5, ...),
     * you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value.
     * If there are multiple such indexes j, you can only jump to the smallest such index j.
     *
     * During even numbered jumps (ie. jumps 2, 4, 6, ...),
     * you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value.
     * If there are multiple such indexes j, you can only jump to the smallest such index j.
     * (It may be the case that for some index i, there are no legal jumps.)
     *
     * A starting index is good if, starting from that index,
     * you can reach the end of the array (index A.length - 1) by jumping some number of times
     * (possibly 0 or more than once.)
     *
     * Return the number of good starting indexes.
     */
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int arrlen = A.length;
        boolean[] oddDoable = new boolean[arrlen];
        boolean[] evenDoable = new boolean[arrlen];

        // storing next jump locations in smallest and largest, offers value fetching based on index
        oddDoable[arrlen - 1] = true;
        evenDoable[arrlen - 1] = true;

        // Use a TreeMap to maintain sorted data, mapping values v=A[i] to indices i
        // TreeMap.lowerKey and TreeMap.higherKey functions can return next smallest and largest values
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[arrlen-1], arrlen);  // key: A[arrlen-1]
                                       // value: index: arrlen-1

        for (int i = arrlen - 2; i >= 0; i--) {
            // use index i + 1 for smallest and largest
            int v = A[i];
            if (map.containsKey(v)) {
                 oddDoable[i] = evenDoable[map.get(v)];
                 evenDoable[i] = oddDoable[map.get(v)];
            } else {
                Integer lower = map.lowerKey(v);
                Integer higher = map.higherKey(v);

                if (lower != null) {
                    evenDoable[i] = oddDoable[map.get(lower)];
                }
                if (higher != null) {
                    oddDoable[i] = evenDoable[map.get(higher)];
                }
            }
            map.put(v, i);
        }

        int res = 0;
        for (boolean b : oddDoable) {
            if (b) res++;
        }
        return res;
    }
}
