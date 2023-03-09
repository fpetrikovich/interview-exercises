import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return new LinkedList<Integer>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> inorder = new LinkedList<>();
        TreeNode curr = root;

        while (true) {

            //push todos los izquierdo
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // popeo, agreo a la lista, y pusheo el derecho
            if (!stack.isEmpty()) {
                curr = stack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                return inorder;
            }
        }

    }
}
