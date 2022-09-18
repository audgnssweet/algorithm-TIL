package javis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

	static char[][] res;

	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited;

	static String[] board;

	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) {
		Solution3 solution3 = new Solution3();
		String[] solution = solution3.solution(new String[] {"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2, 0);
		System.out.println();
	}

	public String[] solution(String[] board, int y, int x) {
		Solution3.board = board;

		visited = new boolean[board.length][];
		for (int i = 0; i < board.length; i++) {
			visited[i] = new boolean[board[i].length()];
		}

		res = new char[board.length][];
		for (int i = 0; i < board.length; i++) {
			res[i] = new char[board[i].length()];
			Arrays.fill(res[i], ' ');
		}

		return click(y, x);
	}

	public String[] click(int y, int x) {
		if (isMine(y, x)) {
			return clickMine(y, x);
		} else {
			return bfs(y, x);
		}
	}

	private String[] bfs(int y, int x) {
		visited[y][x] = true;
		q.offer(new int[] {y, x});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			char curCnt = getCnt(curY, curX);
			res[curY][curX] = curCnt;

			if (curCnt == 'B') {
				for (int i = 0; i < 8; i++) {
					int nextY = curY + dy[i];
					int nextX = curX + dx[i];
					if (isRangeCorrect(nextY, nextX) && !visited[nextY][nextX]) {
						visited[nextY][nextX] = true;
						q.offer(new int[] {nextY, nextX});
					}
				}
			}
		}

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				if (res[i][j] == ' ') {
					res[i][j] = 'E';
				}
			}
		}

		return getResAsString();
	}

	private String[] clickMine(int yPos, int xPos) {
		for (int y = 0; y < board.length; y++) {
			res[y] = board[y].toCharArray();
		}

		res[yPos][xPos] = 'X';
		return getResAsString();
	}

	private String[] getResAsString() {
		return Arrays.stream(res)
			.map(String::new)
			.toArray(String[]::new);
	}

	public boolean isMine(int y, int x) {
		if (isRangeCorrect(y, x)) {
			return board[y].charAt(x) == 'M';
		} else
			return false;
	}

	private boolean isRangeCorrect(int y, int x) {
		return y >= 0 && y < board.length && x >= 0 && x < board[y].length();
	}

	public char getCnt(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			if (isMine(y + dy[i], x + dx[i])) {
				cnt++;
			}
		}
		return cnt == 0 ? 'B' : (char)(cnt + '0');
	}
}
