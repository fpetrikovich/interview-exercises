/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorBinarySearchTree {
    /**
     * TC: O(logN)
     * SC: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < q.val
                ? lowestCommonAncestorRec(root, p, q)
                : lowestCommonAncestorRec(root, q, p);
    }

    public TreeNode lowestCommonAncestorRec(TreeNode node, TreeNode small, TreeNode large) {
        if (node == null) return null;

        if (small.val <= node.val && node.val <= large.val) return node;

        return large.val < node.val
                ? lowestCommonAncestorRec(node.left, small, large)
                : lowestCommonAncestorRec(node.right, small, large);
    }

}