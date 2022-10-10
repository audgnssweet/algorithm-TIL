package 체육복;

import java.util.Arrays;

public class Solution {

	public int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);

		int l = 0, r = 0;
		while (l < lost.length && r < reserve.length) {
			if (lost[l] < reserve[r]) {
				l++;
			} else if (reserve[r] < lost[l]) {
				r++;
			} else {
				lost[l] = reserve[r] = -1;
				l++;
				r++;
			}
		}

		int res = n;
		for (int i = 0; i < lost.length; i++) {
			if (lost[i] != -1) {
				res--;
			}
		}

		l = 0;
		r = 0;
		while (l < lost.length && r < reserve.length) {
			if (lost[l] == -1) {
				l++;
				continue;
			} else if (reserve[r] == -1) {
				r++;
				continue;
			}

			if (lost[l] - 2 >= reserve[r]) {
				r++;
			} else if (lost[l] + 2 <= reserve[r]) {
				l++;
			} else {
				res++;
				r++;
				l++;
			}
		}

		return res;
	}
}
