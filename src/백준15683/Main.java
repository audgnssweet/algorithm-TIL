package 백준15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int res = Integer.MAX_VALUE;

	static int[][] graph;
	static List<int[]> cctvs = new ArrayList<>();

	static int[][] d = {
		{},
		{0, 1, 2, 3},
		{0, 1},
		{0, 1, 2, 3},
		{0, 1, 2, 3},
		{0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] >= 1 && graph[i][j] <= 5) {
					cctvs.add(new int[] {i, j, graph[i][j]});
				}
			}
		}

		dfs(0, new int[cctvs.size()]);

		System.out.println(res);

		br.close();
	}

	private static void dfs(int cnt, int[] dirs) {
		if (cnt == cctvs.size()) {
			check(dirs);
		} else {
			int[] cur = cctvs.get(cnt);
			int cctvNum = cur[2];
			for (int dir : d[cctvNum]) {
				dirs[cnt] = dir;
				dfs(cnt + 1, dirs);
			}
		}
	}

	private static void check(int[] dirs) {
		int[][] graph = copy();
		for (int i = 0; i < dirs.length; i++) {
			int[] cur = cctvs.get(i);
			checkCctv(cur[0], cur[1], cur[2], dirs[i], graph);
		}
		res = Math.min(res, countBlindSpot(graph));
	}

	private static int countBlindSpot(int[][] graph) {
		int cnt = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

	private static void checkCctv(int y, int x, int cctv, int dir, int[][] graph) {
		if (cctv == 1) {
			if (dir == 0) checkUp(y, x, cctv, graph);
			if (dir == 1) checkRight(y, x, cctv, graph);
			if (dir == 2) checkDown(y, x, cctv, graph);
			if (dir == 3) checkLeft(y, x, cctv, graph);
		} else if (cctv == 2) {
			if (dir == 0) {checkLeft(y, x, cctv, graph); checkRight(y, x, cctv, graph);}
			if (dir == 1) {checkUp(y, x, cctv, graph); checkDown(y, x, cctv, graph);}
		} else if (cctv == 3) {
			if (dir == 0){ checkUp(y, x, cctv, graph); checkRight(y, x, cctv, graph);}
			if (dir == 1) {checkRight(y, x, cctv, graph); checkDown(y, x, cctv, graph);}
			if (dir == 2) {checkDown(y, x, cctv, graph); checkLeft(y, x, cctv, graph);}
			if (dir == 3) {checkLeft(y, x, cctv, graph); checkUp(y, x, cctv, graph);}
		} else if (cctv == 4) {
			if (dir == 0) {checkLeft(y, x, cctv, graph); checkUp(y, x, cctv, graph); checkRight(y, x, cctv, graph);}
			if (dir == 1) {checkUp(y, x, cctv, graph); checkRight(y, x, cctv, graph); checkDown(y, x, cctv, graph);}
			if (dir == 2) {checkRight(y, x, cctv, graph); checkDown(y, x, cctv, graph); checkLeft(y, x, cctv, graph);}
			if (dir == 3) {checkDown(y, x, cctv, graph); checkLeft(y, x, cctv, graph); checkUp(y, x, cctv, graph);}
		} else {
			checkUp(y, x, cctv, graph); checkRight(y, x, cctv, graph); checkDown(y, x, cctv, graph); checkLeft(y, x, cctv, graph);
		}
	}

	private static void checkRight(int y, int x, int cctv, int[][] graph) {
		while (x < graph[y].length && graph[y][x] != 6) {
			graph[y][x] = cctv;
			x++;
		}
	}

	private static void checkLeft(int y, int x, int cctv, int[][] graph) {
		while (x >= 0 && graph[y][x] != 6) {
			graph[y][x] = cctv;
			x--;
		}
	}

	private static void checkUp(int y, int x, int cctv, int[][] graph) {
		while (y >= 0 && graph[y][x] != 6) {
			graph[y][x] = cctv;
			y--;
		}
	}

	private static void checkDown(int y, int x, int cctv, int[][] graph) {
		while (y < graph.length && graph[y][x] != 6) {
			graph[y][x] = cctv;
			y++;
		}
	}

	private static int[][] copy() {
		int[][] g = new int[graph.length][graph[0].length];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				g[i][j] = graph[i][j];
			}
		}
		return g;
	}

	private static void print(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
	}
}
