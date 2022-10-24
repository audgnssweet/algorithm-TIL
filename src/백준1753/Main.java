package 백준1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int INF = 999999999;
	static List<int[]>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] VE = br.readLine().split(" ");
		int V = Integer.parseInt(VE[0]);
		int E = Integer.parseInt(VE[1]);

		int start = Integer.parseInt(br.readLine()) - 1;

		int[] res = new int[V];
		for (int i = 0; i < res.length; i++) {
			res[i] = i == start ? 0 : INF;
		}

		graph = new ArrayList[V];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new int[] {e, w});
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> res[i1] - res[i2]);
		pq.offer(start);

		while (!pq.isEmpty()) {
			int cur = pq.poll();

			for (int[] next : graph[cur]) {
				int nextV = next[0];
				int nextW = next[1];

				if (res[nextV] > res[cur] + nextW) {
					res[nextV] = res[cur] + nextW;
					pq.remove(nextV);
					pq.offer(nextV);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (res[i] != INF) {
				sb.append(res[i]);
			} else {
				sb.append("INF");
			}
			sb.append('\n');
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb);

		br.close();
	}
}
