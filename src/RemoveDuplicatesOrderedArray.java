public class RemoveDuplicatesOrderedArray {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) return nums.length;

        int finalPointer = 0;

        for (int i = finalPointer + 1; i < nums.length; i++) {

            // are not duplicated => should add to the array
            if (nums[finalPointer] != nums[i]) {
                nums[++finalPointer] = nums[i];
            }
        }

        return finalPointer + 1;
    }
}
