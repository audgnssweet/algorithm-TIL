package 스티커모으기;

public class Solution {

	public int solution(int sticker[]) {
		int res = 0;

		if (sticker.length == 1) {
			return sticker[0];
		} else if (sticker.length == 2) {
			return Math.max(sticker[0], sticker[1]);
		}

		//첫번쨰를 고를 때
		int[] dp = new int[sticker.length];
		dp[0] = sticker[0];
		dp[1] = sticker[0];
		for (int i = 2; i < sticker.length - 1; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
		}

		res = Math.max(res, dp[sticker.length - 2]);

		//고르지 않을 때
		dp[0] = 0;
		dp[1] = sticker[1]; //무조건 골라야 하는게, 3번째껄 고르는건 어차피 1번 케이스에 포함
		for (int i = 2; i < sticker.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
		}

		res = Math.max(res, dp[sticker.length - 1]);

		return res;
	}
}
