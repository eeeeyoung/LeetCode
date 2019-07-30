import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/partition-labels/.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.equals("")) return res;
        int[][] boundaries = new int[26][2];
        for (int[] boundary : boundaries) Arrays.fill(boundary, -1);
        for (int i = 0; i < S.toCharArray().length; i++) {
            char cI = S.charAt(i);
            if (boundaries[cI - 'a'][0] == -1) {
                boundaries[cI - 'a'][0] = i;
            } else {  // already met once
                boundaries[cI - 'a'][1] = i;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                ((a[0] - b[0]) != 0 ? (a[0] - b[0])
                                    : (a[1] - b[1])));
        for (int[] boundary : boundaries) {
            if (boundary[0] == -1) continue;
            if (boundary[1] == -1) {
                pq.offer(new int[]{boundary[0],boundary[0]});
            } else {
                pq.offer(boundary);
            }
        }
        if (pq.size() <= 1) {
            res.add(S.length());
            return res;
        }
        int[] curr = pq.poll();
        while (!pq.isEmpty()) {
            int[] next = pq.peek();

            if (curr[1] < next[0]) {
                res.add(curr[1] - curr[0] + 1);
                curr = pq.poll();
            } else {
                curr[1] = Math.max(curr[1], next[1]);
                pq.poll();  // dumps next
            }
        }
        res.add(curr[1] - curr[0] + 1);
        return res;
    }
}
