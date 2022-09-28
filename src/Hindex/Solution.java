package Hindex;

import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(new int[] {3, 0, 6, 1, 5, 6, 5, 1});
		System.out.println(solution1);
	}

	public int solution(int[] citations) {
		Arrays.sort(citations);

		for (int i = citations.length - 1; i >= 0; i--) {
			while (i >= 1 && citations[i - 1] == citations[i]) {
				i--;
			}

			int right = citations.length - i;

			int low = i == 0 ? 0 : citations[i - 1];
			for (int cur = citations[i]; cur > low; cur--) {
				if (right >= cur) {
					return cur;
				}
			}
		}

		return 0;
	}
}
