/**
 * https://leetcode.com/problems/odd-even-linked-list/.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);

        ListNode temp = head;
        ListNode tempOdd = dummyOdd;
        ListNode tempEven = dummyEven;

        while (temp != null && temp.next != null) {
            tempOdd.next = temp;
            tempOdd = tempOdd.next;

            tempEven.next = temp.next;
            tempEven = tempEven.next;

            temp = temp.next.next;
        }

        if (temp != null) {
            tempOdd.next = temp;
            tempOdd = tempOdd.next;
        }
        tempEven.next = null;
        tempOdd.next = dummyEven.next;
        return dummyOdd.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
