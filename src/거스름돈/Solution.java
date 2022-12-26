package 거스름돈;

public class Solution {
	public int solution(int n, int[] money) {
		int[] res = new int[n + 1];
		res[0] = 1;
		for (int m : money) {
			for (int i = m; i <= n; i++) {
				res[i] += res[i - m];
			}
		}

		return res[n];
	}
}
