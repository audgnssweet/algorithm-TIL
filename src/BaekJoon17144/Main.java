package BaekJoon17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] YXT = br.readLine().split(" ");
		int t = Integer.parseInt(YXT[2]);

		int[][] map = new int[Integer.parseInt(YXT[0])][Integer.parseInt(YXT[1])];
		int[] aircon = new int[2];
		int idx = 0;
		for (int y = 0; y < map.length; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < map[y].length; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == -1) {
					aircon[idx++] = y;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			spread(map);
			doAirClean(map, aircon);
		}

		int res = 0;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (map[y][x] > 0) {
					res += map[y][x];
				}
			}
		}

		System.out.println(res);

		br.close();
	}

	private static void print(int[][] map) {
		for (int y = 0; y < map.length; y++) {
			System.out.println(Arrays.toString(map[y]));
		}
	}

	private static void spread(int[][] map) {
		int[][] next = new int[map.length][map[0].length];
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (map[y][x] >= 5) {
					int plus = map[y][x] / 5;
					int cnt = 0;

					for (int i = 0; i < 4; i++) {
						int nextY = y + dy[i];
						int nextX = x + dx[i];

						if (inRange(nextY, nextX, map) && !isAirConditioner(nextY, nextX, map)) {
							next[nextY][nextX] += plus;
							cnt++;
						}
					}

					map[y][x] -= (plus * cnt);
				}
			}
		}

		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				map[y][x] += next[y][x];
			}
		}
	}

	private static void doAirClean(int[][] map, int[] aircon) {
		cleanUp(map, aircon[0]);
		cleanDown(map, aircon[1]);
	}

	private static void cleanUp(int[][] map, int aircon) {
		for (int y = aircon - 1; y > 0; y--) {
			map[y][0] = map[y - 1][0];
		}
		for (int x = 0; x < map[0].length - 1; x++) {
			map[0][x] = map[0][x + 1];
		}
		for (int y = 0; y < aircon; y++) {
			map[y][map[0].length - 1] = map[y + 1][map[0].length - 1];
		}
		for (int x = map[0].length - 1; x > 1; x--) {
			map[aircon][x] = map[aircon][x - 1];
		}
		map[aircon][1] = 0;
	}

	private static void cleanDown(int[][] map, int aircon) {
		for (int y = aircon + 1; y < map.length - 1; y++) {
			map[y][0] = map[y + 1][0];
		}
		for (int x = 0; x < map[0].length - 1; x++) {
			map[map.length - 1][x] = map[map.length - 1][x + 1];
		}
		for (int y = map.length - 1; y > aircon; y--) {
			map[y][map[0].length - 1] = map[y - 1][map[0].length - 1];
		}
		for (int x = map[aircon].length - 1; x > 1; x--) {
			map[aircon][x] = map[aircon][x - 1];
		}
		map[aircon][1] = 0;
	}

	private static boolean inRange(int y, int x, int[][] map) {
		return y >= 0 && y < map.length && x >= 0 && x < map[y].length;
	}

	private static boolean isAirConditioner(int y, int x, int[][] map) {
		return map[y][x] == -1;
	}

}
