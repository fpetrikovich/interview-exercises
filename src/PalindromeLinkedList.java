public class PalindromeLinkedList {
    public boolean isPalindromeInefficient(ListNode head) {
        /**
         * Preprocessing to see the length of the list. Reverse the second
         * half of the list and traverse it at the same time.
         */
        int size = getSize(head);

        ListNode tail = reverseListFromIdx(head, (int) Math.ceil(size/2));

        while (tail != null) {
            if (tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    private int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private ListNode reverseListFromIdx(ListNode node, int idx) {
        ListNode prev = null, curr = node, next;

        while (idx > 0) {
            curr = curr.next;
            idx--;
        }

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Esta manera ^ no es la mas eficiente ya que podriamos hacer todo en
     * ciclo usando el Floyd Cycle-Finding alg. Con este, tenemos un puntero
     * mas rapido que otro. Cuando fast llega al final, empezamos a dar vuelta
     * la segunda mitad para que despues empecemos adelante y atras y comparemos.
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;

        // recorrer la lista hasta q fast llegue al final
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Dar vuelta la lista
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Comparar fast y slow
        fast = head;
        slow = prev; // prev es el ultimo nodo de la lista original
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
