import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/.
 */
public class AddTwoNumbersII {
    /**
     * You are given two non-empty linked lists representing two non-negative
     * integers. The most significant digit comes first and each of their nodes
     * contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero,
     * except the number 0 itself.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Using two stacks
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        ListNode temp = l1;
        while (temp != null) {
            one.push(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            two.push(temp.val);
            temp = temp.next;
        }
        int carry = 0;
        ListNode next = null;
        ListNode curr = null;
        while (!one.isEmpty() && !two.isEmpty()) {
            int tempOne = one.pop();
            int tempTwo = two.pop();
            int tempSum = carry + tempOne + tempTwo;
            carry = tempSum >= 10 ? 1 : 0;
            tempSum %= 10;
            curr = new ListNode(tempSum);
            curr.next = next;
            next = curr;
        }

        while (!one.isEmpty()) {
            int tempOne = one.pop();
            int tempSum = carry + tempOne;
            carry = tempSum >= 10 ? 1 : 0;
            tempSum %= 10;
            curr = new ListNode(tempSum);
            curr.next = next;
            next = curr;
        }

        while (!two.isEmpty()) {
            int tempTwo = two.pop();
            int tempSum = carry + tempTwo;
            carry = tempSum >= 10 ? 1 : 0;
            tempSum %= 10;
            curr = new ListNode(tempSum);
            curr.next = next;
            next = curr;
        }

        if (carry != 0) {
            curr = new ListNode(carry);
            curr.next = next;
            next = curr;
        }
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
