package 숫자게임;

import java.util.Arrays;

public class Solution {

	public int solution(int[] A, int[] B) {
		int answer = -1;

		Arrays.sort(A);
		Arrays.sort(B);

		int res = 0;
		int a = A.length - 1;
		int b = B.length - 1;
		while (a >= 0) {
			if (A[a] < B[b]) {
				res++;
				b--;
			}
			a--;
		}

		return res;
	}
}
