/**
 * https://leetcode.com/problems/rotate-list/.
 */
public class RotateList {
    /**
     * Main idea: close the linked list into a circular linked list
     *            use modulo operation to figure out where to break the list
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int n;
        for (n = 1; tail.next != null; n++) {  // also captures the length of the list in n
            tail = tail.next;
        }
        tail.next = head;  // closing the circular linked list

        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)  // if moving from head to tail in a linkedlist of length n,
                                                 // only moves (n - 1) times, thus where the -1 came from
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        new_tail.next = null;
        return new_head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
