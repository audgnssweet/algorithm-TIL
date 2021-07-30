package ValidParentheses;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() == 1 || s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                Character pop = deque.pollLast();
                if (pop == null || chars[i] - 2 != pop) {
                    return false;
                }
            } else {
                deque.addLast(chars[i] == '(' ? '(' - 1 : chars[i]);
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        isValid("()[]{}");
    }
}
