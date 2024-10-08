import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()()()"));
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                deque.addLast(s.charAt(i));
            }

            if (deque.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == ')') {
                if (deque.removeLast() != '(') {
                    throw new NoSuchElementException();
                }
            }

            if (s.charAt(i) == ']') {
                if (deque.removeLast() != '[') {
                    throw new NoSuchElementException();
                }
            }

            if (s.charAt(i) == '}') {
                if (deque.removeLast() != '{') {
                    throw new NoSuchElementException();
                }
            }

        }

        return deque.isEmpty();
    }
}
