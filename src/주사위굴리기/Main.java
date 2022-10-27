package 주사위굴리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, -1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};

	static int[][] map;

	static int[][] dice = {
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NMXYK = br.readLine().split(" ");
		int N = Integer.parseInt(NMXYK[0]);
		int M = Integer.parseInt(NMXYK[1]);
		int Y = Integer.parseInt(NMXYK[2]);
		int X = Integer.parseInt(NMXYK[3]);
		int K = Integer.parseInt(NMXYK[4]);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nextX = X + dx[dir];
			int nextY = Y + dy[dir];
			if (inRange(nextY, nextX)) {
				X = nextX;
				Y = nextY;
				sb.append(move(dir, Y, X)).append('\n');
			}
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb);

		br.close();
	}

	private static boolean inRange(int y, int x) {
		return y >= 0 && y < map.length && x >= 0 && x < map[y].length;
	}

	public static int move(int dir, int y, int x) {
		int res = 0;
		if (dir == 1) {
			res = moveRight();
		}
		if (dir == 2) {
			res = moveLeft();
		}
		if (dir == 3) {
			res = moveUp();
		}
		if (dir == 4) {
			res = moveDown();
		}
		if (map[y][x] == 0) {
			map[y][x] = dice[1][1];
		} else {
			dice[1][1] = map[y][x];
			map[y][x] = 0;
		}
		return res;
	}

	private static int moveRight() {
		int temp = dice[3][1];
		dice[3][1] = dice[1][0];
		dice[1][0] = dice[1][1];
		dice[1][1] = dice[1][2];
		dice[1][2] = temp;

		return dice[3][1];
	}

	private static int moveLeft() {
		int temp = dice[3][1];
		dice[3][1] = dice[1][2];
		dice[1][2] = dice[1][1];
		dice[1][1] = dice[1][0];
		dice[1][0] = temp;

		return dice[3][1];
	}

	private static int moveDown() {
		int temp = dice[0][1];
		dice[0][1] = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = temp;

		return dice[3][1];
	}

	private static int moveUp() {
		int temp = dice[0][1];
		dice[0][1] = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = dice[1][1];
		dice[1][1] = temp;

		return dice[3][1];
	}
}
