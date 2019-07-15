/**
 * https://leetcode.com/problems/insertion-sort-list/.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode next = head;
        ListNode tempNext;
        while (next != null) {
            tempNext = next.next;
            insert(dummy, next);
            next = tempNext;
        }

        return dummy.next;
    }

    private void insert(ListNode dummyHead, ListNode next) {
        ListNode temp = dummyHead.next;
        ListNode prev = dummyHead;
        while (temp != null && next.val > temp.val) {
            temp = temp.next;
            prev = prev.next;
        }

        if (temp == null) {
            prev.next = next;
            next.next = null;
        } else { // next to be inserted between prev and next
            prev.next = next;
            next.next = temp;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
