package ProductOfArrayExceptSelf;

public class SecondProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[][] dp = new int[2][nums.length];
        int left = 0;
        int right = 1;
        int[] res = new int[nums.length];

        dp[left][0] = nums[0];
        dp[right][nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            dp[left][i] = dp[left][i - 1] * nums[i];
            dp[right][nums.length - 1 - i] = dp[right][nums.length - i] * nums[nums.length - 1 - i];
        }

        res[0] = dp[right][1];
        res[nums.length - 1] = dp[left][nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = dp[left][i - 1] * dp[right][i + 1];
        }

        return res;
    }

}
