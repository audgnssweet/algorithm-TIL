package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class BestSlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.getLast() < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = dq.getFirst();
                if (nums[i - k + 1] == dq.getFirst()) {
                    dq.removeFirst();
                }
            }
        }
        return res;
    }
}
