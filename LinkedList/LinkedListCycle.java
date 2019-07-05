/**
 * https://leetcode.com/problems/linked-list-cycle/.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // hare and tortoise algorithm
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise) return true;
        }
        return false;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
