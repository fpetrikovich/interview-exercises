public class SingleNumber {
    /**
     * Hay un numero diferente y el resto es repetido, hayalo.
     */
    public int singleNumber(int[] nums) {
        // XOR will give 0 for all number equal
        // the diferent number will return itself when done against 0.

        int result = 0;

        for (int n : nums) {
            result ^= n;
        }

        return result;
    }
}
