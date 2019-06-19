import java.util.List;

/**
 * https://leetcode.com/problems/reverse-linked-list/.
 */
public class ReverseLinkedList {
    /**
     * Reverse a singly linked list.
     * @param head the input
     * @return head of the reversed ll
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
