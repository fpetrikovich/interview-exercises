import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicated {
    public boolean containsDuplicate(int[] nums) {
        /**
         * Time Complexity O(n)
         * Space Complexity O(n) --> Worst case all elements differ
         */
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            // add returns true if not present in array and false if it is
            if (!set.add(n)) return true;
        }

        return false;
    }

    public boolean containsDuplicateSort(int[] nums) {
        /**
         * Sort the array before hand => more time but less space
         * Time Complexity O(n*logn)
         * Space Complexity O(1)
         */

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }

        return false;
    }
}
