public class PlusOne {
    public int[] plusOne(int[] digits) {

        boolean carry = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry) {
                int res = digits[i] + 1;
                carry = res >= 10;
                digits[i] = res % 10;
            }
        }

        if (carry) {
            int[] newResult = new int[digits.length + 1];
            // for (int j = 0; j < digits.length; j++) {
            //     newResult[j + 1] = digits[j];
            // }
            System.arraycopy(digits, 0, newResult, 1, digits.length);
            newResult[0] = 1;
            return newResult;
        };

        return digits;
    }
}
