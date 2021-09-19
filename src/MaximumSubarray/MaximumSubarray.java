package MaximumSubarray;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            max = Math.max(max, res[i]);
        }

        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = nums.length - 1; i > j; i--) {
                res[i] = res[i - 1] + nums[i];
                max = Math.max(res[i], max);
            }
        }

        return max;
    }
}
