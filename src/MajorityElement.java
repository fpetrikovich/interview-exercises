public class MajorityElement {
    public int majorityElement(int[] nums) {

        /**
         * Time complexity O(N)
         * Space complexity O(1)
         */

        int candidate = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (sum == 0) candidate = nums[i];

            sum += (nums[i] == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
