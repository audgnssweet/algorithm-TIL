package 구슬탈출2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static char[][] arr;

	static int[] red;
	static int[] blue;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		arr = new char[n][m];
		for (int y = 0; y < n; y++) {
			arr[y] = br.readLine().toCharArray();
		}

		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				if (arr[y][x] == 'R') {
					red = new int[] {x, y};
				} else if (arr[y][x] == 'B') {
					blue = new int[] {x, y};
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[10][10][10][10];

		q.offer(new int[] {red[0], red[1], blue[0], blue[1], 0});
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;

		int res = -1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[4] > 10) {
				break;
			}

			int redX = cur[0];
			int redY = cur[1];
			int blueX = cur[2];
			int blueY = cur[3];

			if (isExit(redX, redY)) {
				res = cur[4];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int[] red = move(redX, redY, i);
				int[] blue = move(blueX, blueY, i);

				if (isExit(blue[0], blue[1])) {
					continue;
				}

				if (isSamePos(red, blue)) {
					if (red[2] > blue[2]) {
						red[0] -= dx[i];
						red[1] -= dy[i];
					} else {
						blue[0] -= dx[i];
						blue[1] -= dy[i];
					}
				}

				if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
					q.offer(new int[] {red[0], red[1], blue[0], blue[1], cur[4] + 1});
					visited[red[0]][red[1]][blue[0]][blue[1]] = true;
				}
			}
		}

		System.out.println(res);

		br.close();
	}

	private static boolean isSamePos(int[] red, int[] blue) {
		return (red[0] == blue[0]) && (red[1] == blue[1]);
	}

	private static int[] move(int x, int y, int d) {
		int moveLen = 0;
		do {
			x += dx[d];
			y += dy[d];
			moveLen += 1;
		} while (canMove(x, y));

		if (isExit(x, y)) {
			return new int[] {x, y, moveLen};
		} else {
			return new int[] {x - dx[d], y - dy[d], moveLen - 1};
		}
	}

	private static boolean canMove(int x, int y) {
		return inRange(x, y) && !isWall(x, y) && !isExit(x, y);
	}

	private static boolean inRange(int x, int y) {
		return (y >= 0 && y < arr.length) && (x >= 0 && x < arr[y].length);
	}

	private static boolean isExit(int x, int y) {
		return arr[y][x] == 'O';
	}

	private static boolean isWall(int x, int y) {
		return arr[y][x] == '#';
	}

}
