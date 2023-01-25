public class RomanNumeralsToDigits {

    /*
        BACKWARDS APPROACH :)
        Time complexity: O(n) --> Recorremos el string 1 vez
        Space complexity: O(1) --> Contamos con cantidad fija de variables
    */
    public int romanToIntBackwards(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }

    /*
        FORWARD APPROACH :( very unorganized
        Time complexity: O(n) --> Recorremos el string 1 vez
        Space complexity: O(1) --> Contamos con cantidad fija de variables
    */
    public int romanToInt(String s) {
        // Base case, empty string
        if (s.isEmpty()) return 0;

        int finalDigit = 0;

        // convert the first symbol to digits
        int curr = this.convertSingleRomanToNum(s.charAt(0));
        int next = curr;

        for (int pos = 0; pos < s.length(); pos++) {

            // Case there is an next symbol
            next = this.getNextSymbolAsNum(s, pos);

            // Handle if the first symbol is smaller or not
            if (curr < next) {
                finalDigit += (next - curr); // add subtraction to the digit
                pos++; // add to pos, we do not want to view the symbols again
                curr = this.getNextSymbolAsNum(s, pos);
            } else {
                finalDigit += curr;
                curr = next;
            }
        }
        return finalDigit;
    }

    private int getNextSymbolAsNum(String s, int pos) {
        if (pos + 1 < s.length()) {
            return this.convertSingleRomanToNum(s.charAt(pos+1));
        }
        return 0;
    }

    private int convertSingleRomanToNum(char r) {
        switch(r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
