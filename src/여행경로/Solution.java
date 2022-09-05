package 여행경로;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	static String[] tmp;

	static String[][] t;
	static boolean[] visit;
	PriorityQueue<String[]> pq = new PriorityQueue<>((a1, a2) -> {
		for (int i = 0; i < a1.length; i++) {
			int comp = a1[i].compareTo(a2[i]);
			if (comp != 0) {
				return comp;
			}
		}
		return 0;
	});

	public String[] solution(String[][] tickets) {
		t = tickets;
		visit = new boolean[tickets.length];

		tmp = new String[tickets.length + 1];

		dfs("ICN", 0);

		return pq.poll();
	}

	private void dfs(String start, int depth) {
		if (depth == t.length) {
			tmp[t.length] = start;
			pq.offer(Arrays.copyOf(tmp, tmp.length));
		} else {
			for (int i = 0; i < t.length; i++) {
				if (!visit[i] && t[i][0].equals(start)) {
					visit[i] = true;
					tmp[depth] = t[i][0];
					dfs(t[i][1], depth + 1);
					visit[i] = false;
				}
			}
		}
	}
}
