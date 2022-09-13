package 타일링2N;

public class Solution {

	public int solution(int n) {
		int[] res = new int[60_001];
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++) {
			res[i] = (res[i - 1] + res[i - 2]) % 1_000_000_007;
		}

		return res[n];
	}
}
