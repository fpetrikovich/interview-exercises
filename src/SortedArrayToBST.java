public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recSorting(nums, 0, nums.length - 1);
    }

    public TreeNode recSorting(int[] nums, int low, int high) {

        if (low > high) return null;

        int mid = (int)(low + high) / 2;

        TreeNode n = new TreeNode(nums[mid]);
        n.left = recSorting(nums, low, mid - 1);
        n.right = recSorting(nums, mid + 1, high);

        return n;

    }
}
