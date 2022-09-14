package 멀리뛰기;

public class Solution {
	public long solution(int n) {
		int rem = 1234567;
		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = ((dp[i - 1] % rem) + (dp[i - 2] % rem)) % rem;
		}

		return dp[n];
	}
}
