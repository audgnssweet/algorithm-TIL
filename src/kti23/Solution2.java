package kti23;

public class Solution2 {

	public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {

		if(minratio == 0 && maxratio == 0) {
			return money;
		}

		long m = money;

		for(int month = 1; month <= months; month++) {
			long 소유가정금액 = m - (m % 100);
			if(소유가정금액 < threshold) {
				return (int)m;
			}

			long gap = 소유가정금액 - threshold;

			long ratio = minratio;
			while(gap >= ranksize) {
				gap -= ranksize;
				ratio += 1;
			}

			ratio = (ratio > maxratio) ? maxratio : ratio;


			long 징수금액 = (int)(소유가정금액 * ((double)ratio / 100));

			m = (m - 징수금액);
		}

		return (int)m;
	}


}
