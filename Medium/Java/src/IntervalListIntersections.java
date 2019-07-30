import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 *  numbers x with a <= x <= b.  The intersection of two closed intervals is
 *  a set of real numbers that is either empty, or can be represented as a
 *  closed interval.  For example, the intersection of [1, 3] and [2, 4] is
 *  [2, 3].)
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        int lenA = A.length, lenB = B.length;
        int posA = 0, posB = 0;
        while (posA < lenA && posB < lenB) {
            if (A[posA][1] < B[posB][0]) {
                posA++;
                continue;
            }
            if (B[posB][1] < A[posA][0]) {
                posB++;
                continue;
            }
            int start = Math.max(A[posA][0], B[posB][0]);
            int end = Math.min(A[posA][1], B[posB][1]);
            res.add(new int[]{start, end});

            if (A[posA][1] > B[posB][1]) {
                posB++;
            } else {
                posA++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
