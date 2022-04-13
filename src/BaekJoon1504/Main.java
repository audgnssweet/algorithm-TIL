package BaekJoon1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	private static List<Node>[] graph;
	private static int[] res;
	private static PriorityQueue<Integer> pq;
	private static int[][] ans;
	private static int N;
	private static int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NE = br.readLine().split(" ");
		N = Integer.parseInt(NE[0]);
		int E = Integer.parseInt(NE[1]);

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			String[] startEndWeight = br.readLine().split(" ");
			int start = Integer.parseInt(startEndWeight[0]);
			int end = Integer.parseInt(startEndWeight[1]);
			int weight = Integer.parseInt(startEndWeight[2]);

			graph[start].add(new Node(end, weight));
			graph[end].add(new Node(start, weight));
		}

		String[] needs = br.readLine().split(" ");
		int v1 = Integer.parseInt(needs[0]);
		int v2 = Integer.parseInt(needs[1]);

		//초기화 끝
		int one = dijkstra(1, v1);
		int two = dijkstra(1, v2);
		int three = dijkstra(v1, v2);
		int four = dijkstra(v2, v1);
		int five = dijkstra(v1, N);
		int six = dijkstra(v2, N);

		int res = Math.min(one + three + six, two + four + five);
		System.out.println(res >= INF ? -1 : res);

		br.close();
	}

	private static int dijkstra(int start, int end) {
		res = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if(i != start) {
				res[i] = INF;
			}
		}

		pq = new PriorityQueue<>((n1, n2) -> res[n1] - res[n2]);
		pq.offer(start);

		while (!pq.isEmpty()) {
			Integer cur = pq.poll();
			for (Node next : graph[cur]) {
				if (res[next.v] > res[cur] + next.w) {
					res[next.v] = res[cur] + next.w;
					pq.remove(next.v);
					pq.offer(next.v);
				}
			}
		}

		return res[end];
	}

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}
