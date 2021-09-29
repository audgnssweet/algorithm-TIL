package GetRidOfPairs;

import java.util.LinkedList;

public class Solution {

    public int solution(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
