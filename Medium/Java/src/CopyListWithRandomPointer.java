/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/.
 */
public class CopyListWithRandomPointer {

    /* Triple Iteration */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // First Round, replicating (deep copy) new node immediately after old
        Node replica;
        Node curr = head;
        while (curr != null) {
            replica = new Node(curr.val, curr.next, curr.random);
            curr.next = replica;
            curr = replica.next;
        }

        // Second Round, moving replicated node's pointers to one next
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Third Round
        curr = head;
        Node dupHead = new Node(0, null, null);
        Node copy, copyIter = dupHead;
        Node tempNext = curr;

        while (curr != null) {
            tempNext = curr.next.next;

            copy = curr.next;
            copyIter.next = copy;
            copyIter = copy;

            curr.next = tempNext;

            curr = tempNext;
        }

        return dupHead.next;
    }

    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
