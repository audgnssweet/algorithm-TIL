package _Theory.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	static int INF = 9999;

	static int[][] g = {
		{0, 3, 6, 7},
		{3, 0, 1, INF},
		{6, 1, 0, 1},
		{7, INF, 1, 0}
	};

	public static void main(String[] args) {
		int[] d = new int[g.length];
		Arrays.fill(d, INF);
		d[0] = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> d[n1] - d[n2]);
		pq.offer(0);
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			for (int i = 0; i < g[cur].length; i++) {
				if (d[i] > d[cur] + g[cur][i]) {
					d[i] = d[cur] + g[cur][i];
					pq.remove(i);
					pq.offer(i);
				}
			}
		}

		System.out.println(Arrays.toString(d));
	}
}
