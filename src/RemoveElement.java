public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int finalPointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[finalPointer++] = nums[i];
            }
        }
        return finalPointer;
    }
}
