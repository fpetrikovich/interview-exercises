public class MissingNumber {
    public int missingNumber3(int[] nums) {
        /**
         * Will traverse the array onces to convert the value at the index
         * to the negative equivalent value.
         * When done, is all are -1, then n is missing. Else, the index of
         * the number that is not -1 is missing.
         * Have to handle the case of 0 separately :(
         */

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (Math.abs(n) < nums.length) {
                if (n < -1 * nums.length) {
                    nums[0] *= -1;
                } else {
                    nums[Math.abs(n)] = (nums[Math.abs(n)]) != 0 ? -1 * nums[Math.abs(n)] : -1 * (n+1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (nums[i] >= 0) return i;
        }
        return nums.length;
    }

    /**
     * We know that the sum of the range [0,n] is (n * (n-1)) / 2.
     * If we subtract the sum of the array to this, we will know which
     * number is missing.
     */
    public int missingNumber2(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        return (nums.length * (nums.length + 1) / 2) - total;
    }

    /**
     * Can use XOR with the indexes + 1 and the values to get the value
     * that is missing. Use the + 1 since xor with 0 will always give the
     * same value back, so the numbers we use the values [1, n] to know
     * exactly which of the values is missing.
     * Remember: n XOR n = 0
     */
    public int missingNumber(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= (i+1);
        }
        return xor;
    }
}
