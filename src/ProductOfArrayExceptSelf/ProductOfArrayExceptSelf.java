package ProductOfArrayExceptSelf;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][i] = nums[i - 1];
        }

        for (int diag = 1; diag <= nums.length; ++diag) {
            int i = 1;
            for (int j = i + diag; j <= nums.length; ++j, ++i) {
                dp[i][j] = dp[i][j-1] * dp[j][j];
            }
        }

        res[0] = dp[2][nums.length];
        for (int i = 2; i < nums.length; i++) {
            res[i - 1] = dp[1][i - 1] * dp[i + 1][nums.length];
        }
        res[nums.length - 1] = dp[1][nums.length - 1];

        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

