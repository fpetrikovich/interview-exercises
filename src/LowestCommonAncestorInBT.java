
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorInBT {
    TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorRec(root, p, q);
        return lca;
    }

    public boolean lowestCommonAncestorRec(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        boolean inLeft = lowestCommonAncestorRec(node.left, p, q);
        boolean inRight = lowestCommonAncestorRec(node.right, p, q);
        boolean isCurr = node.val == p.val || node.val == q.val;

        boolean isLCA = inLeft && inRight || inLeft && isCurr || inRight && isCurr;

        if (isLCA) lca = node;

        return inLeft || inRight || isCurr;
    }
}
