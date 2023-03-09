public class ReverseInteger {
    public int reverse(int x) {
        /**
         * Time complexity O(logx) ==> logx is the amount of digits x has.
         * Space complexity O(1)
         */
        boolean isNegative = x < 0;

        int size = String.valueOf(x).length() - (isNegative ? 1 : 0);
        int aux, result = 0;

        x = Math.abs(x);

        for (int i = 0; i < size; i++) {
            aux = x % 10;
            x = x / 10;
            result += (int) (aux * Math.pow(10, size - i - 1)); // set to int to correctly handle the sum

            // overflow
            if (result < 0) return 0;
        }
        return isNegative ? -1 * result : result;
    }
}
