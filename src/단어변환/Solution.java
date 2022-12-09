package 단어변환;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	class Node {
		String data;
		int depth;

		public Node(String data, int depth) {
			this.data = data;
			this.depth = depth;
		}
	}

	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];
		Queue<Node> q = new LinkedList<>();

		Node start = new Node(begin, 0);
		q.offer(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.data.equals(target)) {
				return cur.depth;
			}

			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && canGo(cur.data, words[i])) {
					visited[i] = true;
					q.offer(new Node(words[i], cur.depth + 1));
				}
			}
		}

		return 0;
	}

	public boolean canGo(String cur, String next) {
		int cnt = 0;
		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != next.charAt(i)) {
				cnt++;
			}
		}
		return cnt == 1;
	}
}
