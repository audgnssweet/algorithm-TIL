package 숫자의표현;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(15);
	}

	public int solution(int n) {
		int res = 1;
		for (int i = 1; i < (n / 2) + 1; i++) {
			for (int gap = 1; gap < n - i; gap++) {
				int sum = ((i + gap) * (i + gap + 1) / 2) - ((i - 1) * i / 2);
				if (sum > n) {
					break;
				} else if (n == sum) {
					res++;
					break;
				}
			}
		}

		return res;
	}
}
