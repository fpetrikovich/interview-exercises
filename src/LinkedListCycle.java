public class LinkedListCycle {
    /**
     * My approach, but it changes the list itself
     */
    public boolean hasCycleDummy(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode curr = head, aux;

        while (curr != null) {
            if (curr.next == dummy) return true;
            aux = curr.next;
            curr.next = dummy;
            curr = aux;
        }
        return false;
    }

    /**
     * Floyd’s Cycle-Finding Algorithm
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;

            if (head == fast) return true;
        }
        return false;
    }
}
