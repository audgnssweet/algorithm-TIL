package 백준15685;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			chk(x, y, d, g);
		}

		int res = 0;
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				if (map[y][x] && map[y][x + 1] && map[y + 1][x] && map[y + 1][x + 1]) {
					res++;
				}
			}
		}

		System.out.println(res);

		br.close();
	}

	private static void chk(int x, int y, int d, int g) {
		List<Integer> dirs = new ArrayList<>();
		dirs.add(d);

		for (int i = 1; i <= g; i++) {
			for (int j = dirs.size() - 1; j >= 0; j--) {
				dirs.add((dirs.get(j) + 1) % 4);
			}
		}

		map[y][x] = true;
		for (int dir : dirs) {
			y += dy[dir];
			x += dx[dir];
			map[y][x] = true;
		}
	}
}
