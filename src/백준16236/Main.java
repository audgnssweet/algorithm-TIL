package 백준16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	static int[][] map;
	static int N;
	static Shark shark;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(j, i);
					map[i][j] = 0;
				}
			}
		}

		while (bfs()) {
		}

		System.out.println(shark.moveLen);

		br.close();
	}

	private static boolean bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
			if (a1[2] != a2[2]) {
				return a1[2] - a2[2];
			}
			if (a1[0] != a2[0]) {
				return a1[0] - a2[0];
			}
			return a1[1] - a2[1];
		});

		boolean[][] visited = new boolean[N][N];
		visited[shark.y][shark.x] = true;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {shark.y, shark.x, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextY = cur[0] + dy[i];
				int nextX = cur[1] + dx[i];
				int nextLen = cur[2] + 1;

				if (inRange(nextY, nextX) && !visited[nextY][nextX] && canMove(nextY, nextX)) {
					if (canEat(nextY, nextX)) {
						pq.offer(new int[] {nextY, nextX, nextLen});
					} else {
						q.offer(new int[] {nextY, nextX, nextLen});
					}
					visited[nextY][nextX] = true;
				}
			}
		}

		if (pq.isEmpty()) {
			return false;
		}

		int[] min = pq.poll();
		shark.eat(min[1], min[0], min[2]);
		map[min[0]][min[1]] = 0;
		return true;
	}

	private static boolean inRange(int y, int x) {
		return y >= 0 && y < map.length && x >= 0 && x < map[y].length;
	}

	private static boolean canMove(int y, int x) {
		return map[y][x] <= shark.level;
	}

	private static boolean canEat(int y, int x) {
		return map[y][x] < shark.level && map[y][x] != 0;
	}

	static class Shark {
		int x;
		int y;
		int level;
		int eatCnt;
		int moveLen;

		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
			this.level = 2;
			this.eatCnt = 0;
			this.moveLen = 0;
		}

		public void eat(int x, int y, int len) {
			move(x, y, len);
			eatCnt++;
			if (eatCnt == level) {
				level++;
				eatCnt = 0;
			}
		}

		private void move(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.moveLen += len;
		}
	}
}
