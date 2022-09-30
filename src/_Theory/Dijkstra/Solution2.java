package _Theory.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = 100_000_000;
	static int v, e, k;
	static int[] d;
	static List<int[]>[] g;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		d = new int[v];
		g = new List[v];

		boolean[] visited = new boolean[v];

		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(s.nextToken());
			int end = Integer.parseInt(s.nextToken());
			int weight = Integer.parseInt(s.nextToken());

			g[start - 1].add(new int[] {end - 1, weight});
		}

		Arrays.fill(d, INF);
		d[k - 1] = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> d[n1] - d[n2]);
		pq.offer(k - 1);
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;

			for (int[] next : g[cur]) {
				int v = next[0];
				int w = next[1];

				if (d[v] >= d[cur] + w) {
					d[v] = d[cur] + w;
					pq.offer(v);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < v; i++) {
			if (d[i] == INF)
				sb.append("INF\n");
			else
				sb.append(d[i] + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
