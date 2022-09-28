package 최솟값만들기;

import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] {1, 4, 2}, new int[] {5, 4, 4});
	}

	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += (A[i] * B[B.length - 1 - i]);
		}

		System.out.println(sum);
		return sum;
	}
}
