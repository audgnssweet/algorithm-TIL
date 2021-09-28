package StringCompression;

import java.util.LinkedList;

public class Solution {

    public static int solution(String s) {
        LinkedList<String> stack = new LinkedList<>();

        int res = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int cur = 0;
            StringBuilder sb = new StringBuilder("");

            int count = 0;
            String temp = "";
            while (cur < s.length() && cur + i <= s.length()) {
                String substring = s.substring(cur, cur + i);
                if (temp.compareTo(substring) == 0) {
                    count += 1;
                } else {
                    if (count != 0) {
                        stack.addLast(String.valueOf(count));
                    }
                    stack.addLast(substring);
                    temp = substring;
                    count = 1;
                }
                cur += i;
            }

            stack.addLast(String.valueOf(count));
            if (cur < s.length()) {
                stack.addLast(s.substring(cur));
            }

            while (!stack.isEmpty()) {
                if (stack.peekLast().compareTo("1") == 0) {
                    stack.pollLast();
                } else {
                    sb.append(stack.pollLast());
                }
            }

            res = Math.min(res, sb.length());
        }

        return res;
    }
}

