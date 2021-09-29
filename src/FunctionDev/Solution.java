package FunctionDev;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int portion = (100 - progresses[i]) / speeds[i];
            int rest = (100 - progresses[i]) % speeds[i];
            queue.addLast(rest > 0 ? portion + 1 : portion);
        }

        int count = 0;
        int cur = -1;
        while (!queue.isEmpty()) {
            Integer first = queue.pollFirst();
            if (first > cur) {
                if (cur > 0) {
                    res.add(count);
                }
                cur = first;
                count = 1;
            } else {
                count += 1;
            }
        }

        res.add(count);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
