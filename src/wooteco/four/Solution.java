package wooteco.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static int[] solution(String s) {
        List<Integer> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            int temp = 0;
            while (!stack.isEmpty() && stack.peek() != ch) {
                stack.pop();
                temp += 1;
            }
            if (temp > 0) {
                res.add(temp);
            }
            stack.push(ch);
        }

        if (!res.isEmpty() && s.charAt(0) == s.charAt(s.length() - 1)) {
            res.set(0, res.get(0) + stack.size());
        } else {
            res.add(stack.size());
        }
        System.out.println(res);

        return res.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

}
