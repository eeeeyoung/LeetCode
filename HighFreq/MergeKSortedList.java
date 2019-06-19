import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Merge k Sorted Lists.
 * https://leetcode.com/problems/merge-k-sorted-lists/.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(cmp);
        boolean allNull = true;
        for (ListNode heads : lists) {
            if (heads != null) {
                allNull = false;
                pq.add(heads);
            }
        }
        if (allNull) return null;
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            ListNode origNext = curr.next;
            if (origNext != null) {
                pq.add(origNext);
            }
        }
        return res.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
