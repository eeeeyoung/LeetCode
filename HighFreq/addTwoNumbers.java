/**
 * https://leetcode.com/problems/add-two-numbers/.
 */
public class addTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order and each of their nodes
     * contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero,
     * except the number 0 itself.
     * @param l1 head of first linked list
     * @param l2 head of second linked list
     * @return head of linked list representing the result
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // init
        int cf, sum;
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;

        // base case
        sum = l1.val + l2.val;
        ListNode res = new ListNode(sum % 10);
        cf = sum >= 10 ? 1 : 0; // uses a carry bit
        ListNode curr = res;

        // recursions
        while (l1next != null && l2next != null) {
            sum = l1next.val + l2next.val + cf;
            if (sum >= 10) {
                cf = 1;
            } else {
                cf = 0;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1next = l1next.next;
            l2next = l2next.next;
        }

        // copy the rest
        while (l1next != null) {
            sum = l1next.val + cf;
            curr.next = new ListNode(sum % 10);
            if (sum >= 10) {
                cf = 1;
            } else {
                cf = 0;
            }
            curr = curr.next;
            l1next = l1next.next;
        }
        while (l2next != null) {
            sum = l2next.val + cf;
            curr.next = new ListNode(sum % 10);
            if (sum >= 10) {
                cf = 1;
            } else {
                cf = 0;
            }
            curr = curr.next;
            l2next = l2next.next;
        }
        if (cf == 1) {
            curr.next = new ListNode(1);
        }
        return res;
    }

    /**
     * Definition of a singly linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
