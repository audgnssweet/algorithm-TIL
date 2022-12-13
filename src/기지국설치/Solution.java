package 기지국설치;

public class Solution {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;

		final int boundary = 2 * w + 1;

		int left = 1;
		for (int s : stations) {
			int right = s - w - 1;

			if (right >= left) {
				int range = right - left + 1;
				answer += (range % boundary == 0) ? range / boundary : range / boundary + 1;
			}

			left = s + w + 1;
		}

		if (left <= n) {
			int range = n - left + 1;
			answer += (range % boundary == 0) ? range / boundary : range / boundary + 1;
		}

		return answer;
	}
}
