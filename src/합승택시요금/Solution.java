package 합승택시요금;

public class Solution {

	static int[][] graph;

	static int INF = 999_9999;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		init(n, fares);
		floydWarshall(n);
		int res = INF;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, graph[i][s - 1] + graph[i][a - 1] + graph[i][b - 1]);
		}

		return res;
	}

	private void init(int n, int[][] fares) {
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = i == j ? 0 : INF;
			}
		}
		for (int[] fare : fares) {
			int start = fare[0];
			int end = fare[1];
			int weight = fare[2];

			graph[start - 1][end - 1] = weight;
			graph[end - 1][start - 1] = weight;
		}
	}

	private void floydWarshall(int n) {
		//거치는곳
		for (int k = 0; k < n; k++) {
			//시작
			for (int i = 0; i < n; i++) {
				//끝
				for (int j = 0; j < n; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}
