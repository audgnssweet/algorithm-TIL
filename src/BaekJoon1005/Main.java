package BaekJoon1005;

import java.util.*;
import java.io.*;

/**
 * 위상 정렬을 사용
 * 1. 방향성이 있고
 * 2. 사이클이 없어야 한다.
 */
public class Main {

	private static int[] indegree;
	private static Queue<Integer> q;
	private static int[] times;
	private static int[] res;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			indegree = new int[N + 1];
			times = new int[N + 1];
			res = new int[N + 1];
			q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
				res[i] = times[i];
			}

			graph = new ArrayList[N + 1];
			for(int i = 1; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				graph[start].add(end);
				indegree[end]++;
			}

			//초기화 끝
			int target = Integer.parseInt(br.readLine());
			topologicalSort();
			System.out.println(res[target]);
		}

		br.close();
	}

	private static void topologicalSort() {
		for(int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while(!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				res[next] = Math.max(res[next], res[cur] + times[next]);

				indegree[next]--;
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
