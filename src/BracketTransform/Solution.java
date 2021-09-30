package BracketTransform;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static String solution(String p) {
        return transform(p);
    }

    private static String transform(String p) {
        if (p.length() == 0) {
            return "";
        }
        if (isCorrect(p)) {
            return p;
        }

        int idx = divide(p);
        String u = p.substring(0, idx);
        String v = idx == p.length() ? "" : p.substring(idx);

        if (isCorrect(u)) {
            return u + transform(v);
        } else {
            StringBuilder sb = new StringBuilder("");
            sb.append("(");
            sb.append(transform(v));
            sb.append(")");

            String substring = u.substring(1, u.length() - 1);
            for (int i = 0; i < substring.length(); i++) {
                if (substring.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            return sb.toString();
        }
    }

    public static boolean isCorrect(String str) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peekLast() == '(') {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }

    public static int divide(String str) {
        int openCount = 0, closeCount = 0;
        int idx;
        for (idx = 0; idx < str.length(); ++idx) {
            if (str.charAt(idx) == '(') {
                openCount += 1;
            } else {
                closeCount += 1;
            }

            if (openCount == closeCount) {
                break;
            }
        }
        return idx + 1;
    }
}
