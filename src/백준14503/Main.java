package 백준14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	static int[][] graph;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		graph = new int[N][M];
		visited = new boolean[N][M];

		String[] YXD = br.readLine().split(" ");
		int Y = Integer.parseInt(YXD[0]);
		int X = Integer.parseInt(YXD[1]);
		int D = Integer.parseInt(YXD[2]);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 1;
		boolean isEnd = false;
		visited[Y][X] = true;
		while (!isEnd) {

			boolean canGo = false;
			for (int i = 0; i < 4; i++) {
				D = getNextDir(D);
				int nextY = Y + dy[D];
				int nextX = X + dx[D];

				if (inRange(nextY, nextX) && isNotWall(nextY, nextX) && isNotVisited(nextY, nextX)) {
					canGo = true;
					Y = nextY;
					X = nextX;
					break;
				}
			}

			if (canGo) {
				res++;
			} else {
				if (canBack(Y, X, D)) {
					Y -= dy[D];
					X -= dx[D];
				} else {
					isEnd = true;
				}
			}

			visited[Y][X] = true;
		}

		System.out.println(res);

		br.close();
	}

	private static boolean canBack(int y, int x, int d) {
		int backY = y - dy[d];
		int backX = x - dx[d];

		return inRange(backY, backX) && isNotWall(backY, backX);
	}

	private static boolean isNotVisited(int y, int x) {
		return !visited[y][x];
	}

	private static boolean isNotWall(int y, int x) {
		return graph[y][x] != 1;
	}

	private static boolean inRange(int y, int x) {
		return (y >= 0 && y < graph.length) &&
			(x >= 0 && x < graph[y].length);
	}

	private static int getNextDir(int d) {
		return d > 0 ? d - 1 : 3;
	}
}
