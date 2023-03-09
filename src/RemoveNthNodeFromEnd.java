public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0, nodeBefore;

        // Calculate the size of the list
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // Start from the beginning
        curr = head;

        // Want to stop at the node before the one we want to delete
        nodeBefore = size - n - 1;

        // Case where we delete the first node
        if (nodeBefore < 0) {
            return head.next;
        }

        // Move towards the node before the removal one
        for (int i = 0; i < nodeBefore; i++) {
            curr = curr.next;
        }

        // i == nodeBefore --> remove node
        curr.next = curr.next == null ? null : curr.next.next;

        return head;
    }
}
