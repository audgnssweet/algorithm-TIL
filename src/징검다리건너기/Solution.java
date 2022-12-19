package 징검다리건너기;

class Solution {
	public int solution(int[] stones, int k) {
		int min = 1;
		int max = 200_000_000;

		while (min <= max) {
			int mid = (min + max) / 2;

			if (canCross(stones, k, mid)) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return min;
	}

	boolean canCross(int[] stones, int k, int 사람수) {
		int 못건너는돌 = 0;
		for (int s : stones) {
			if (s - 사람수 <= 0) {
				못건너는돌++;
			} else {
				못건너는돌 = 0;
			}

			if (못건너는돌 == k) {
				return false;
			}
		}

		return true;
	}
}

