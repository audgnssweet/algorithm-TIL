package nqueen;

public class Solution {
	static int n;
	static int res;

	static int[] arr;

	public int solution(int n) {
		Solution.n = n;
		arr = new int[n];
		dfs(0);
		return res;
	}

	void dfs(int depth) {
		if (depth == n) {
			res++;
		} else {
			for (int i = 0; i < n; i++) {
				if (canSet(depth, i)) {
					arr[depth] = i;
					dfs(depth + 1);
				}
			}
		}
	}

	boolean canSet(int depth, int i) {
		int gap = 1;
		while (gap <= depth) {
			if (arr[depth - gap] == i || arr[depth - gap] == i - gap || arr[depth - gap] == i + gap) {
				return false;
			}
			gap++;
		}
		return true;
	}
}
