public class LongestPalindromeSubstring {
    /**
     We observe that a palindrome mirrors around its center. Therefore, a palindrome
     can be expanded from its center, and there are only 2n−12n - 12n−1 such centers.

     You might be asking why there are 2n−12n - 12n−1 but not nnn centers? The reason
     is the center of a palindrome can be in between two letters. Such palindromes have
     even number of letters (such as "abba") and its center are between the two 'b's.

     Time Complexity O(N^2)
     Space Complexity O(1)

     O(N) time use Manacher's Algorithm (very complex)
     */
    public String longestPalindrome(String s) {
        int result = 0;
        String curr, longestSubstring = "";

        for (int i = 0; i < s.length(); i++) {
            curr = findPalindrome(s, i, i);
            longestSubstring = curr.length() > longestSubstring.length() ? curr : longestSubstring;
            curr = findPalindrome(s, i, i + 1);
            longestSubstring = curr.length() > longestSubstring.length() ? curr : longestSubstring;
        }
        return longestSubstring;
    }

    private String findPalindrome(String s, int left, int right) {
        String palindrome = "";

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindrome = s.substring(left, right + 1);
            left--;
            right++;
        }
        return palindrome;
    }
}
