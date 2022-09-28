package kakao;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(3, 4, 2, 3, 3, 1, 5);
	}

	static char[][] miro;

	static int endY;
	static int endX;

	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {1, 0, 0, -1};
	static String[] d = {"d", "l", "r", "u"};

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		miro = new char[n][m];
		endY = r - 1;
		endX = c - 1;

		Set<String> set = new HashSet<>();
		PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> {
			int dict = n1.cur.compareTo(n2.cur);
			if (dict == 0) {
				return n1.k - n2.k;
			}
			return dict;
		});
		q.offer(new Node(y - 1, x - 1, 0, ""));
		set.add("");

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;

			//일단 찾았으면
			if (cur.x == endX && cur.y == endY) {
				if ((k - cur.k) % 2 == 0) {

				}
			}

			if (cur.k == k && cur.x == endX && cur.y == endY) {
				return cur.cur;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				String dir = d[i];

				String nextDir = cur.cur + dir;
				if (inRange(nextX, nextY) && !set.contains(nextDir) && cur.k < k) {
					q.offer(new Node(nextX, nextY, cur.k + 1, nextDir));
					set.add(nextDir);
				}
			}
		}

		return "impossible";
	}

	private boolean inRange(int x, int y) {
		return (y >= 0 && y < miro.length) && (x >= 0 && x < miro[y].length);
	}

	static class Node {
		int x;
		int y;
		int k;
		String cur;

		public Node(int x, int y, int k, String cur) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cur = cur;
		}
	}
}
