public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        /**
         * We syncronize the pointers by going through one list and then
         * switching the pointers of the list until the nodes a == b.
         * This works because each pointer will travel the same amount
         * of nodes in the end (m + n), syncronizing them the second time
         * around. View solution for visualization.
         */

        // Pointers
        ListNode a = headA, b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }


    public ListNode getIntersectionNodeLen(ListNode headA, ListNode headB) {

        /**
         * If one list is longer than the other, we can skip however
         * many extra nodes it has a the beginning to have lists the same
         * length. With this, the intersection will occur at the "same time".
         * Need to preprocess both list to find the length first :(
         */

        int m = this.getListLength(headA), n = this.getListLength(headB);

        if (m > n) {
            headA = this.skipNodes(headA, m - n);
        } else {
            headB = this.skipNodes(headB, n - m);
        }

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private ListNode skipNodes(ListNode l, int skip) {
        while (l != null && skip > 0) {
            l = l.next;
            skip--;
        }
        return l;
    }

    private int getListLength(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }
}
