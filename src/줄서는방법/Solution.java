package 줄서는방법;

public class Solution {

	static boolean[] visited;
	static int[] res;
	static int n;
	static long k;

	static int target;

	static boolean isEnd = false;

	public int[] solution(int n, long k) {
		visited = new boolean[n];
		res = new int[n];
		Solution.n = n;
		Solution.k = k;
		target = 1;

		dfs(0);

		return res;
	}

	private void dfs(int depth) {
		if (depth == n) {
			if (target == k) {
				isEnd = true;
			} else {
				target++;
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					res[depth] = i + 1;
					dfs(depth + 1);
					if (isEnd) {
						break;
					}
					visited[i] = false;
				}
			}
		}
	}
}
