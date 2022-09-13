package 등산코스정하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

	static List<Node>[] graph;

	static int[] parent;

	static boolean[] visit;
	static int res = Integer.MAX_VALUE;
	static int resEnd = Integer.MAX_VALUE;

	static boolean[] ends;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		Arrays.sort(paths, Comparator.comparingInt(a -> a[2]));
		graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		kruskal(n, paths);

		ends = new boolean[n + 1];
		for (int sumit : summits) {
			ends[sumit] = true;
		}
		for (int gate : gates) {
			visit = new boolean[n + 1];
			visit[gate] = true;
			dfs(gate, 0);
		}

		return new int[] {resEnd, res};
	}

	private void dfs(int cur, int max) {
		if (ends[cur]) {
			if (max == res) {
				resEnd = Math.min(resEnd, cur);
			} else if (max < res) {
				res = max;
				resEnd = cur;
			}
		} else {
			for (Node next : graph[cur]) {
				if (!visit[next.v]) {
					visit[next.v] = true;
					dfs(next.v, Math.max(max, next.w));
					visit[next.v] = false;
				}
			}
		}
	}

	private void kruskal(int n, int[][] paths) {
		int k = 0;
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0, cnt = 0; i < paths.length && cnt < n - 1; i++) {
			int start = paths[i][0];
			int end = paths[i][1];
			int weight = paths[i][2];

			int startParent = findParent(start);
			int endParent = findParent(end);

			if (startParent == endParent) {
				continue;
			}
			int p = Math.min(startParent, endParent);

			parent[startParent] = p;
			parent[endParent] = p;

			graph[start].add(new Node(end, weight));
			graph[end].add(new Node(start, weight));
			cnt++;
		}
	}

	private int findParent(int cur) {
		if (cur == parent[cur]) {
			return cur;
		} else {
			parent[cur] = findParent(parent[cur]);
			return parent[cur];
		}
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
