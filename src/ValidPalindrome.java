public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();
        char lc, rc;

        while (left < right) {
            lc = chars[left];
            rc = chars[right];

            if (Character.isLetterOrDigit(lc) && Character.isLetterOrDigit(rc)) {
                if (lc != rc) return false;
                left++;
                right--;
            } else if (!Character.isLetterOrDigit(lc)) {
                left++;
            } else {
                right--;
            }
        }
        return true;
    }
}
