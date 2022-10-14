package 타겟넘버;

class Solution {

	static int[] arr;
	static int tar;
	static int res = 0;

	public int solution(int[] numbers, int target) {
		arr = numbers;
		tar = target;

		dfs(0, 0);

		return res;
	}

	private void dfs(int depth, int cur) {
		if (depth == arr.length) {
			if (cur == tar) {
				res++;
			}
		} else {
			dfs(depth + 1, cur + arr[depth]);
			dfs(depth + 1, cur - arr[depth]);
		}
	}
}
