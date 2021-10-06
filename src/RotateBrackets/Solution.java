package RotateBrackets;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    static Deque<Character> dq = new LinkedList<>();

    public static int solution(String s) {
        for (char c : s.toCharArray()) {
            dq.add(c);
        }

        int res = 0;
        for (int count = 0; count < s.length(); count++) {
            if (check()) {
                res += 1;
            }
            dq.addLast(dq.pollFirst());
        }

        return res;
    }

    private static boolean check() {
        Deque<Character> stack = new LinkedList<>();
        for (Character ch : dq) {
            if (!stack.isEmpty() && isMatch(ch, stack.peekLast())) {
                stack.removeLast();
            } else {
                stack.addLast(ch);
            }
        }

        return stack.isEmpty();
    }

    static boolean isMatch(char cur, char match) {
        if ((cur == ')' && match == '(') || (cur == '}' && match == '{') || (cur == ']' && match == '[')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        solution("[](){}");
    }
}
