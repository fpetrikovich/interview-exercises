public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverseListRec(null, head);
    }

    private ListNode reverseListIt(ListNode node) {
        ListNode prev = null, curr = node, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode reverseListRec(ListNode n1, ListNode n2) {
        // If n2 is node, we have reached the end of the list
        // return n1 which will be the last node (aka the new head).
        if (n2 == null) return n1;

        ListNode head = reverseListRec(n2, n2.next);

        n2.next = n1;

        return head;
    }
}
