/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/.
 */
public class RemoveNthElementFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode tmp = head;
        ListNode prev = head;

        if (head.next == null) return null;
        if (nextN(head, n) == null) return head.next;

        while (nextN(head, n) != null) {
            // Each time before moving the tmp pointer, 3 things to do

            prev = tmp;         // First, preserve the previous pointer tmp in prev
            tmp = tmp.next;     // Second, advance tmp by one
            head = tmp;         // Lastly, reset position of head to tmp
        }

        prev.next = tmp.next;

        return res;
    }

    private ListNode nextN(ListNode head, int n) {
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
