public class BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        return this.maxDepthRec(root);
    }

    public int maxDepthRec(TreeNode node) {
        if (node == null) return 0;

        // devuelvo el max depth desde la derecha o izquerda + 1
        return Math.max(this.maxDepthRec(node.left), this.maxDepthRec(node.right)) + 1;
    }
}
