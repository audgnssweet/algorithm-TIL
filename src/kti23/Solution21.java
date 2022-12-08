package kti23;

public class Solution21 {
	public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {

		if (minratio == 0 && maxratio == 0) {
			return money;
		}

		for (int month = 1; month <= months; month++) {
			int 소유가정금액 = money - (money % 100);
			if (소유가정금액 < threshold) {
				return money;
			}

			int gap = 소유가정금액 - threshold;

			int ratio = minratio;
			while (gap >= ranksize) {
				gap -= ranksize;
				ratio += 1;
			}

			ratio = Math.min(ratio, maxratio);

			int 징수금액 = (int)(소유가정금액 * ((double)ratio / 100));

			money = money - 징수금액;
		}

		return money;
	}


}
