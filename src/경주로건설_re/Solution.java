package 경주로건설_re;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	int[] dx = {0, 1, 0, -1};
	int[] dy = {-1, 0, 1, 0};

	public int solution(int[][] board) {
		int n = board.length;

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, -1, 0});

		int[][][] map = new int[4][n][n];
		for (int d = 0; d < 4; d++) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					map[d][y][x] = 999999;
				}
			}
		}

		int res = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			int curDir = cur[2];
			int curCost = cur[3];

			if (curY == n - 1 && curX == n - 1) {
				res = Math.min(res, curCost);
			}

			for (int i = 0; i < 4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				int nextDir = i;

				int nextCost = curCost + ((curDir == nextDir || curDir == -1) ? 100 : 600);

				if (!inRange(nextY, nextX, board) || board[nextY][nextX] == 1) {
					continue;
				}

				if (map[nextDir][nextY][nextX] >= nextCost) {
					map[nextDir][nextY][nextX] = nextCost;
					q.offer(new int[] {nextY, nextX, nextDir, nextCost});
				}
			}
		}

		return res;
	}

	boolean inRange(int y, int x, int[][] board) {
		return y >= 0 && y < board.length && x >= 0 && x < board[y].length;
	}
}