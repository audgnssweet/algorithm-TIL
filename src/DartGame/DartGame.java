package DartGame;

import java.util.LinkedList;

public class DartGame {

    public int dartGame(String dartResult) {
        LinkedList<Integer> stack = new LinkedList<>();

        String[] operands = dartResult.split("\\D+");
        String[] operators = dartResult.split("\\d+");

        for (int i = 0; i < operands.length; i++) {
            Integer num = Integer.valueOf(operands[i]);
            String operator = operators[i + 1];

            switch (operator.charAt(0)) {
                case 'D':
                    stack.addLast(num * num);
                    break;
                case 'T':
                    stack.addLast(num * num * num);
                    break;
                default:
                    stack.addLast(num);
            }

            if (operator.length() == 2) {
                if (operator.charAt(1) == '#' && !stack.isEmpty()) {
                    Integer cur = stack.pollLast();
                    stack.addLast(-1 * cur);
                } else if (operator.charAt(1) == '*' && !stack.isEmpty()) {
                    Integer cur = stack.pollLast();
                    if (!stack.isEmpty()) {
                        Integer past = stack.pollLast();
                        stack.addLast(past << 1);
                    }
                    stack.addLast(cur << 1);
                }
            }

        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pollLast();
        }

        return res;
    }
}
