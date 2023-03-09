import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /**
     * Loop through the first number (a) and then use left and right pointers,
     * moving inwards from the right if the sum is too large and from the left
     * if its too small (this because the array is sorted).
     *
     * TC: O(n2)
     * SC: O(1)
     */

    public List<List<Integer>> threeSum(int[] nums) {
        int a, left, right, threeSum;
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            a = nums[i];

            // Avoid duplicates
            if (i > 0 && a == nums[i-1]) continue;

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                threeSum = a + nums[left] + nums[right];

                if (threeSum > 0) {
                    right--;
                }
                else if (threeSum < 0) {
                    left++;
                }
                else {
                    result.add(new LinkedList<Integer>(Arrays.asList(a, nums[left], nums[right])));
                    left++;
                    while (nums[left] == nums[left - 1] & left < right) {
                        left++;
                    }
                }
            }

        }

        return result;
    }
}
