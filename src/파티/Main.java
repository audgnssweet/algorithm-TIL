package 파티;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 9999999;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int vertCnt = Integer.parseInt(split[0]);
		int edgeCnt = Integer.parseInt(split[1]);
		int target = Integer.parseInt(split[2]);

		List<int[]>[] graph = new List[vertCnt + 1];
		List<int[]>[] reverseGraph = new List[vertCnt + 1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[start].add(new int[] {end, weight});
			reverseGraph[end].add(new int[] {start, weight});
		}

		int[] first = dijkstra(target, graph);
		int[] second = dijkstra(target, reverseGraph);

		int res = Integer.MIN_VALUE;
		for (int i = 1; i < first.length; i++) {
			res = Math.max(res, (first[i] + second[i]));
		}

		System.out.println(res);

		br.close();
	}

	private static int[] dijkstra(int start, List<int[]>[] graph) {
		int[] res = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		for (int i = 1; i < res.length; i++) {
			res[i] = i == start ? 0 : INF;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> res[n1] - res[n2]);
		for (int i = 1; i < res.length; i++) {
			pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			visited[cur] = true;

			for (int[] next : graph[cur]) {
				int nextVert = next[0];
				int weight = next[1];
				if (!visited[nextVert] && res[nextVert] > res[cur] + weight) {
					res[nextVert] = res[cur] + weight;
					pq.remove(nextVert);
					pq.offer(nextVert);
				}
			}
		}

		return res;
	}
}
