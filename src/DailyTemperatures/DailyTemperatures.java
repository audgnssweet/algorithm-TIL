package DailyTemperatures;

import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{1};
        }
        int[] res = new int[temperatures.length];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peekLast() < temperatures[i]) {
                stack.pollLast();
                Integer pop = stack.pollLast();
                res[pop] = i - pop;
            }
            stack.addLast(i);
            stack.addLast(temperatures[i]);
        }

        while (!stack.isEmpty()) {
            stack.pollLast();
            res[stack.pollLast()] = 0;
        }

        return res;
    }
}
