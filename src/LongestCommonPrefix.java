import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    /**
     * VERTICAL SCANNING
     * Time complexity : O(S), where S is the sum of all characters in all strings.
     * In the worst case there will be nnn equal strings with length mmm and the
     * algorithm performs S=m⋅nS = m \cdot nS=m⋅n character comparisons. Even though
     * the worst case is still the same as Approach 1, in the best case there are at
     * most n⋅minLenn \cdot minLenn⋅minLen comparisons where minLenminLenminLen is
     * the length of the shortest string in the array.
     *
     *  Note: Stream one is slower than other one.
     */
    public String longestCommonPrefixWithStream(String[] strs) {

        if (strs == null ||  strs.length == 0) return "";

        String shortestString = Arrays.asList(strs)
                .stream()
                .min(Comparator.comparingInt(String::length))
                .get();

        for (int i = 0; i < shortestString.length(); i++) {
            char currMatch = shortestString.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (currMatch != strs[j].charAt(i)) {
                    return shortestString.substring(0, i);
                }
            }
        }
        return shortestString;
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null ||  strs.length == 0) return "";

        String baseString = strs[0];

        for (int i = 0; i < baseString.length(); i++) {

            char c = baseString.charAt(i);

            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return baseString.substring(0, i);
                }
            }
        }
        return baseString;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"floren", "flor", "florencia"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
