import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        PriorityQueue<LLNode> pq = new PriorityQueue<>((a, b) -> a.num - b.num);
        for (int[] rows : matrix) {
            LLNode head = new LLNode(rows[0], null);
            LLNode temp = head;
            for (int i = 1; i < rows.length; i++) {
                temp.next = new LLNode(rows[i], null);
                temp = temp.next;
            }
            pq.add(head);
        }

        while (!pq.isEmpty()) {
            LLNode res = pq.poll();
            if (res.num == target) {
                return true;
            } else {
                if (res.next != null) {
                    pq.offer(res.next);
                }
            }
        }
        return false;
    }

    private class LLNode {
        int num;
        LLNode next;
        public LLNode(int val, LLNode next) {
            this.num = val;
            this.next = next;
        }
    }
}
