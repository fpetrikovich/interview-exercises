import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElemInBST {
    // NON recursive
    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(true) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            if (!stack.isEmpty()) {
                curr = stack.pop();
                k--;

                if (k == 0) return curr.val;

                curr = curr.right;
            }
        }
    }

    // Recursive
    private int count = 0, result = 0;

    public int kthSmallest2(TreeNode root, int k) {
        this.count = k;
        this.smallestRec(root);
        return this.result;
    }

    private void smallestRec(TreeNode curr) {
        if (curr == null || this.count <= 0) return;
        smallestRec(curr.left);
        if (--this.count == 0) this.result = curr.val;
        smallestRec(curr.right);
    }
}
