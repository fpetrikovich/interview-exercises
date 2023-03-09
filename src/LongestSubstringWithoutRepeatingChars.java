import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    // SLIDING WINDOW OPTIMIZED
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();

        //This variable stores the starting index of the current substring. Initially, it is set to 0.
        int window = 0;

        /*
        This array stores the last index at which each character (from ASCII value 32 to 127) was seen.
        Initially,all the values in the array are set to 0.
        */
        int[] idx = new int[96];

        for (int i = 0; i < n; i++) {
            /* Converts the current character to its ASCII value, subtracts 32 to shift the range to 0-95,
            and assigns the value to variable c.*/
            int c = s.charAt(i) - 32;

            /*
            Updates the starting index of the current substring. If the current character has been
            seen before, the starting index is set to the last index at which that character was seen.
            If the current character has not been seen before, the starting index remains the same.
            */
            window = Math.max(idx[c], window);

            /**
             Updates the length of the longest substring without repeating
             characters that we have seen so far. The current substring is from window
             to i+1, so the length of current substring is i-window+1, ans is set to the
             max of the current length and the previous one.
             */
            ans = Math.max(ans , i - window + 1);
            idx[c] = i + 1;
        }
        return ans;
    }

    // SLIDING WINDOW
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        char[] str = s.toCharArray();

        int start = 0, end = 0, result = 0;
        char c;

        while (end < str.length) {
            c = str[end++];

            // Check if we have already encountered the char
            if (!set.add(c)) {
                // If so, move the pointer until we remove the
                // char from the substring
                while (str[start] != c) {
                    set.remove(str[start++]);
                }
                // Want to move one more than the repeated char
                if (start < end) start++;
            }
            System.out.println("start = " + start);
            System.out.println("end = " + end);

            result = Math.max(result, end - start);
        }
        return result;
    }
}
