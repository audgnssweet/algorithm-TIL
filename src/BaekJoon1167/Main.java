package BaekJoon1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] visited;
	private static List<Node>[] graph;
	private static int answer;
	private static int restartIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeCount = Integer.parseInt(br.readLine());
		graph = new ArrayList[nodeCount + 1];
		visited = new boolean[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startNodeIdx = Integer.parseInt(st.nextToken());
			graph[startNodeIdx] = new ArrayList<>();
			while (st.hasMoreElements()) {
				int nextNodeIdx = Integer.parseInt(st.nextToken());
				if (nextNodeIdx == -1) {
					break;
				}
				int nextNodeWeight = Integer.parseInt(st.nextToken());
				graph[startNodeIdx].add(new Node(nextNodeIdx, nextNodeWeight));
			}
		}
		//초기화 끝
		dfs(1, 0);
		dfs(restartIdx, 0);

		System.out.println(answer);

		br.close();
	}

	private static void dfs(int vertIdx, int curLength) {
		visited[vertIdx] = true;

		if (answer < curLength) {
			answer = curLength;
			restartIdx = vertIdx;
		}

		for (int i = 0; i < graph[vertIdx].size(); i++) {
			Node next = graph[vertIdx].get(i);
			if (!visited[next.v]) {
				dfs(next.v, curLength + next.w);
			}
		}
		visited[vertIdx] = false;
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
