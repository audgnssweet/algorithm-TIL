package kakao;

import java.util.Arrays;

class Solution2 {

	static long res = 0;

	static int cap;
	static int deliveryCnt = 0;

	static int[] deliveries;
	static int dIdx;

	static int[] pickups;
	static int pIdx;

	// public static void main(String[] args) {
	// 	Solution2 solution = new Solution2();
	// 	solution.solution(4, 5, new int[] {1, 0, 3, 1, 2}, new int[] {0, 3, 0, 4, 0});
	// }

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		deliveryCnt = Arrays.stream(deliveries).sum();
		Solution2.deliveries = deliveries;
		Solution2.pickups = pickups;
		Solution2.cap = cap;
		dIdx = deliveries.length - 1;
		pIdx = pickups.length - 1;

		dIdx = findDidx();
		pIdx = findPidx();

		int i = 1;
		while (!isEnd()) {
			int curDelivery = Math.min(deliveryCnt, cap);

			int curLen = Math.max(dIdx, pIdx) + 1;

			delivery(curDelivery);
			dIdx = findDidx();

			pickup(cap);
			pIdx = findPidx();

			res += (curLen * 2L);
		}

		return res;
	}

	private void pickup(int remain) {
		for (int i = pIdx; i >= 0; i--) {
			if (pickups[i] == 0) {
				continue;
			}
			if (pickups[i] >= remain) {
				pickups[i] -= remain;
				return;
			} else {
				remain -= pickups[i];
				pickups[i] = 0;
			}
		}
	}

	private void delivery(int cur) {
		for (int i = dIdx; i >= 0; i--) {
			if (deliveries[i] == 0) {
				continue;
			}
			if (deliveries[i] >= cur) {
				deliveries[i] -= cur;
				deliveryCnt -= cur;
				return;
			} else {
				deliveryCnt -= deliveries[i];
				cur -= deliveries[i];
				deliveries[i] = 0;
			}
		}
	}

	private boolean isEnd() {
		return (pIdx == -1) && (dIdx == -1);
	}

	private int findDidx() {
		for (int i = dIdx; i >= 0; i--) {
			if (deliveries[i] != 0) {
				return i;
			}
		}
		return -1;
	}

	private int findPidx() {
		for (int i = pIdx; i >= 0; i--) {
			if (pickups[i] != 0) {
				return i;
			}
		}
		return -1;
	}
}
