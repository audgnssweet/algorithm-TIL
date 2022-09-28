package line;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static char[][] wall;
	static char[][] res;
	static boolean[][] visited;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new String[] {"H.H", ".HX", "H.H"});
	}

	public int[][] solution(String[] wall) {
		Solution.wall = new char[wall.length][];
		res = new char[wall.length][];
		visited = new boolean[wall.length][];
		for (int i = 0; i < wall.length; i++) {
			char[] chars = wall[i].toCharArray();
			Solution.wall[i] = chars;
			res[i] = new char[wall[i].length()];
			visited[i] = new boolean[wall[i].length()];
		}

		//x, y
		Queue<int[]> q = new LinkedList<>();
		visited[wall.length - 1][0] = true;
		q.offer(new int[] {0, wall.length - 1, 1});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curCnt = cur[2];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (inRange(nextX, nextY) && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					q.offer(new int[] {nextX, nextY, curCnt + 1});
				}
			}

			for (int i = 2; i <= 3; i++) {
				int nextX = curX + i;
				int nextY = curY;

				if (inRange(nextX, nextY) && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					q.offer(new int[] {nextX, nextY, curCnt + 1});
				}
			}

			for (int i = -2; i >= -3; i--) {
				int nextX = curX + i;
				int nextY = curY;

				if (inRange(nextX, nextY) && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					q.offer(new int[] {nextX, nextY, curCnt + 1});
				}
			}
		}

		return null;
	}

	private boolean inRange(int nextX, int nextY) {
		return (nextX >= 0 && nextX < wall[0].length) &&
			(nextY >= 0 && nextY < wall.length);
	}
}
