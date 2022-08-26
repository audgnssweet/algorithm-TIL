package ranking;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	static List<Integer>[] winGraph;
	static List<Integer>[] loseGraph;
	static boolean[] visited;

	public int solution(int n, int[][] results) {
		initGraph(n, results);

		int res = 0;
		for (int player = 1; player <= n; player++) {
			visited = new boolean[n + 1];
			dfs(winGraph, player);
			int losers = count(n, player);

			visited = new boolean[n + 1];
			dfs(loseGraph, player);
			int winners = count(n, player);

			if ((losers + winners) == n - 1) {
				res++;
			}
		}

		return res;
	}

	private void dfs(List<Integer>[] graph, int start) {
		if (!visited[start]) {
			visited[start] = true;
			for (int next : graph[start]) {
				dfs(graph, next);
			}
		}
	}

	private int count(int n, int player) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i] && i != player) {
				cnt++;
			}
		}
		return cnt;
	}

	private void initGraph(int n, int[][] results) {
		winGraph = new List[n + 1];
		loseGraph = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			winGraph[i] = new ArrayList<>();
			loseGraph[i] = new ArrayList<>();
		}

		for (int[] winnerLoser : results) {
			int winner = winnerLoser[0];
			int loser = winnerLoser[1];

			winGraph[winner].add(loser);
			loseGraph[loser].add(winner);
		}
	}
}
