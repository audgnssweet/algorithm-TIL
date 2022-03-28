package BaekJoon2252;

import java.util.*;
import java.io.*;

public class Main {

	private static List<Integer>[] graph;
	private static Queue<Integer> q;
	private static int[] indegree;
	private static List<Integer> res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		q = new LinkedList<>();
		res = new LinkedList<>();
		indegree = new int[N + 1];
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			String[] startEnd = br.readLine().split(" ");
			int start = Integer.parseInt(startEnd[0]);
			int end = Integer.parseInt(startEnd[1]);

			graph[start].add(end);
			indegree[end]++;
		}

		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		//초기화 끝

		topologicalSort();

		for(int node : res) {
			System.out.print(node + " ");
		}
	}

	private static void topologicalSort() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);

			for(int next: graph[cur]) {
				indegree[next]--;

				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
