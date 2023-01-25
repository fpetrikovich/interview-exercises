public class MoveZero {
    // More efficient time wise and memory wise
    public void moveZeroes(int[] nums) {
        int finalPointer = 0, idx = 0;

        while (finalPointer < nums.length && idx < nums.length) {
            if (nums[finalPointer] != 0 ) {
                // Value is in the correct position
                finalPointer++;
                idx = finalPointer;
            } else if (nums[finalPointer] == 0 && nums[idx] == 0) {
                // Search until next non zero is found
                idx++;
            } else {
                // Swap the numbers
                nums[finalPointer++] = nums[idx];
                nums[idx] = 0;
            }
        }
    }

    // Its practically the same
    public void moveZeroes2(int[] nums) {

        for (int lastFoundZero = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int aux = nums[lastFoundZero];
                nums[lastFoundZero++] = nums[cur];
                nums[cur] = aux;
            }
        }
    }
}
