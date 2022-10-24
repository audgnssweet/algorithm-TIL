package 연구소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static int N;
	static int M;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(res);

		br.close();
	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			res = Math.max(res, getSafeArea());
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j] == 0) {
						graph[i][j] = 1;
						dfs(cnt + 1);
						graph[i][j] = 0;
					}
				}
			}
		}
	}

	private static int getSafeArea() {
		int[][] g = copyGraph();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && graph[i][j] == 2) {
					bfs(g, visited, i, j);
				}
			}
		}

		return getCnt(g);
	}

	private static int getCnt(int[][] graph) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void bfs(int[][] graph, boolean[][] visited, int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int curY = cur[0];
			int curX = cur[1];

			graph[curY][curX] = 2;

			for (int i = 0; i < 4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];

				if (inRange(nextY, nextX) && !visited[nextY][nextX] && (graph[nextY][nextX] == 0
					|| graph[nextY][nextX] == 2)) {
					visited[nextY][nextX] = true;
					q.offer(new int[] {nextY, nextX});
				}
			}
		}
	}

	private static boolean inRange(int y, int x) {
		return y >= 0 && y < graph.length && x >= 0 && x < graph[y].length;
	}

	private static int[][] copyGraph() {
		int[][] g = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				g[i][j] = graph[i][j];
			}
		}
		return g;
	}
}
