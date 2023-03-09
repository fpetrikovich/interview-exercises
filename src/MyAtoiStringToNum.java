public class MyAtoiStringToNum {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        int limit = -Integer.MAX_VALUE;

        // Read in and ignore any leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Check for sign
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // Read in digits
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            // Check for overflow/underflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(index) - '0');
            index++;
        }

        return result * sign;
    }
}
