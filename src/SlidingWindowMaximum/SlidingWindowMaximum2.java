package SlidingWindowMaximum;

public class SlidingWindowMaximum2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = k - 1;
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        while (right < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }
            res[idx++] = max;
            left += 1; right += 1;
        }

        return res;
    }
}
