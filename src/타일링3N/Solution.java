package 타일링3N;

public class Solution {

	public int solution(int n) {
		int rem = 1_000_000_007;

		long[] res = new long[5001];
		res[1] = 0;
		res[2] = 3;
		res[3] = 0;
		res[4] = 11;

		for (int i = 6; i <= n; i += 2) {
			res[i] = ((((res[i - 2] * 4) % rem) - ((res[i - 4]) % rem)) + rem) % rem;
		}

		return (int)res[n];
	}

}
