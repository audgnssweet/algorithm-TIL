package 최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	static int INF = 999_999_9;

	static List<int[]>[] graph;

	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ve = br.readLine().split(" ");
		int v = Integer.parseInt(ve[0]);
		int e = Integer.parseInt(ve[1]);

		int start = Integer.parseInt(br.readLine());

		d = new int[v + 1];
		Arrays.fill(d, INF);
		d[start] = 0;

		graph = new List[v + 1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			String[] sew = br.readLine().split(" ");
			int st = Integer.parseInt(sew[0]);
			int en = Integer.parseInt(sew[1]);
			int we = Integer.parseInt(sew[2]);

			graph[st].add(new int[] {en, we});
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> d[n1] - d[n2]);
		pq.offer(start);
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			for (int[] next : graph[cur]) {
				int nextV = next[0];
				int nextW = next[1];

				if (d[nextV] > d[cur] + nextW) {
					d[nextV] = d[cur] + nextW;
					pq.remove(nextV);
					pq.offer(nextV);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			sb.append(d[i] != INF ? d[i] : "INF").append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

		br.close();
	}
}
