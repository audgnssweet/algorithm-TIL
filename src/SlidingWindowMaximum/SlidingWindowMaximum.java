package SlidingWindowMaximum;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int ws = 2;
        while (ws <= k) {
            for (int i = 0; i <= nums.length - ws; i++) {
                nums[i] = Math.max(nums[i], nums[i + 1]);
            }
            ws += 1;
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }

        return res;
    }
}
