import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (this.isClosing(c)) {

                // check if empty or if parentheses dont match => invalid if so
                if (stack.isEmpty() || !this.isValidOrder(stack.pop(), c)) {
                    return false;
                }

            } else {
                // push the opening symbol
                stack.push(c);
            }
        }

        // check that the stack is empty =>
        // means that all parentesis were closed
        return stack.isEmpty();
    }

    private boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean isValidOrder(char open, char close) {
        return open == '(' && close == ')'
            || open == '[' && close == ']'
            || open == '{' && close == '}';
    }
}
