public class DeleteListNode {
    public void deleteNode(ListNode node) {
        // Since we cannot change the reference of next of the previous
        // node, we must shift all the values to the left and remove the
        // last node by turning it to null;

        while (node != null && node.next != null) {
            // Update value
            node.val = node.next.val;

            if (node.next.next == null){
                node.next = null;
            }
            node = node.next;
        }
    }
}
