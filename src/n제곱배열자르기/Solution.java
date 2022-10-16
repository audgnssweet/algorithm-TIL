package n제곱배열자르기;

class Solution {
	public int[] solution(int n, long left, long right) {
		int[] res = new int[(int)(right - left + 1)];
		for (long i = left; i <= right; i++) {
			int row = (int)(i / n);
			int col = (int)(i % n);
			res[(int)(i - left)] = Math.max(row, col) + 1;
		}
		return res;
	}
}
