/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/.
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Given a sorted linked list,
     * delete all duplicates such that each element appear only once.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;  // don't advance the pointer head
            } else {
                head = head.next; // advance the pointer head
            }
        }

        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
