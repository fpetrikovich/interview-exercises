import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    // Recursive way
    public boolean isSymmetric(TreeNode root) {
        return this.isSymmetricRec(root, root);
    }

    public boolean isSymmetricRec(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        if (!this.isSymmetricRec(node1.left, node2.right)) return false;
        if (!this.isSymmetricRec(node1.right, node2.left)) return false;

        return true;
    }

    // Non recursive solution --> BFS through the left and right
    // Checking when popping the elements
    public boolean isSymmetricBFS(TreeNode root) {

        if (root == null) return true;

        Queue<TreeNode> qLeft = new LinkedList<>();
        Queue<TreeNode> qRight = new LinkedList<>();
        TreeNode l, r;

        qLeft.offer(root.left);
        qRight.offer(root.right);

        while (!qLeft.isEmpty() && !qRight.isEmpty()) {
            l = qLeft.poll();
            r = qRight.poll();

            // Si no se cumple que ambos son null o ninguno es null y tienen
            // el mismo valor => no son espejos.
            if (!(
                    l == null && r == null ||
                            (l != null && r != null && l.val == r.val)
            )) return false;

            if (l != null) {
                qLeft.offer(l.left);
                qLeft.offer(l.right);
            }
            if (r != null) {
                qRight.offer(r.right);
                qRight.offer(r.left);
            }
        }

        return qLeft.isEmpty() && qRight.isEmpty();
    }
}
