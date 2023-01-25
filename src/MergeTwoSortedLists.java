
class MergeTwoSortedLists {

    /**
     * Time Complexity --> O(N) where N is the total number of nodes.
     * Space Complexity --> O(1), only use constant space for first and curr nodes
     * which are actually references to the already existing nodes.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Case with the dummy node. It uses more space to create and store the node, but it
     * simplifies the cases greatly.
     */
    public ListNode mergeTwoListsDummy(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0), curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // set the remaining nodes of the list to the new one
        curr.next = list1 == null ? list2 : list1;

        return dummy.next;
    }

    /**
     * This way requires lots of case checking, but it uses less space.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // base cases for any empty list
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;

        ListNode first, curr;

        // get the first node of our sorted list
        if (list1.val < list2.val) {
            first = list1;
            list1 = list1.next;
        } else {
            first = list2;
            list2 = list2.next;
        }
        curr = first;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // set the remaining nodes of the list to the new one
        curr.next = list1 == null ? list2 : list1;

        return first;
    }
}