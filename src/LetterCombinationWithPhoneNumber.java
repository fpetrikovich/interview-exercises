import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationWithPhoneNumber {
    static Map<Character,char[]> letToDigitMap = new HashMap<>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new LinkedList<>();

        StringBuilder curr = new StringBuilder(digits.length());
        curr.append(digits);

        List<String> results = new LinkedList<>();

        letterCombinationsRec(digits, curr, 0, results);

        return results;
    }

    public void letterCombinationsRec(String digits, StringBuilder curr, int i, List<String> results) {

        // Base case, when the string we are building equals digit length
        if (i >= digits.length()) {
            results.add(curr.toString());
            return;
        }

        // For each digit, loop through the possibilities, add it to the same
        // index, and call the function again for the next index.
        for (char c : letToDigitMap.get(digits.charAt(i))) {
            curr.setCharAt(i, c);
            letterCombinationsRec(digits, curr, i + 1, results);
        }
    }
}
