/**
 * https://leetcode.com/problems/linked-list-cycle-ii/.
 */
public class LinkedListCycleII {
    /**
     * distance(tortoise) = distance(hare).
     * 2(F+a) = F+a+b+a
     * 2F+2a = F+2a+b
     * F = b
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode stop = cycleExists(head);
        if (stop == null) return null;
        ListNode temp = stop.next;
        while (head != temp) {
            temp = temp.next;
            if (temp == stop) {
                head = head.next;
            }
        }
        return head;
    }

    private ListNode cycleExists(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) return hare;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
