package 데브매칭.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(new String[] {
			"AABCA.QA",
			"AABC..QX",
			"BBBC.Y..",
			".A...T.A",
			"....EE..",
			".M.XXEXQ",
			"KL.TBBBQ"
		});
		System.out.println(solution1);
	}

	static boolean[][] visited;
	static char[][] map;

	static int[] res = new int[26];

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public int solution(String[] maps) {
		map = new char[maps.length][];
		for (int i = 0; i < maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}
		visited = new boolean[maps.length][];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = new boolean[map[i].length];
		}

		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (!visited[y][x] && Character.isAlphabetic(map[y][x])) {
					bfs(x, y);
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= 25; i++) {
			max = Math.max(max, res[i]);
		}

		return max;
	}

	private void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[y][x] = true;
		q.offer(new int[] {x, y});

		int[] alpha = new int[26];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			char ch = map[curY][curX];
			alpha[ch - 'A']++;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (inRange(nextX, nextY) && !visited[nextY][nextX] && Character.isAlphabetic(map[nextY][nextX])) {
					visited[nextY][nextX] = true;
					q.offer(new int[] {nextX, nextY});
				}
			}
		}

		int winner = 0;
		int max = 0;
		for (int i = 25; i >= 0; i--) {
			if (alpha[i] > max) {
				max = alpha[i];
				winner = i;
			}
		}

		int occupy = 0;
		for (int i = 0; i <= 25; i++) {
			if (alpha[i] == max) {
				res[i] += alpha[i];
			} else {
				occupy += alpha[i];
			}
		}

		res[winner] += occupy;
	}

	private boolean inRange(int x, int y) {
		return (y >= 0 && y < map.length) && (x >= 0 && x < map[y].length);
	}

	private static void print(String[] maps) {
		for (int i = 0; i < maps.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

		for (int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
	}
}
