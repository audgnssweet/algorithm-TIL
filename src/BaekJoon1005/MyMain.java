package BaekJoon1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyMain {

	private static List<Integer>[] nodes;
	private static int[] times;
	private static boolean[] visited;

	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			String[] NK = br.readLine().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);

			visited = new boolean[N + 1];
			nodes = new ArrayList[N + 1];
			for(int i = 1; i <= N; i++) {
				nodes[i] = new ArrayList<>();
			}
			times = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i <= K; i++) {
				String[] endStart = br.readLine().split(" ");
				int end = Integer.parseInt(endStart[0]);
				int start = Integer.parseInt(endStart[1]);

				nodes[start].add(end);
			}

			int start = Integer.parseInt(br.readLine());
			//초기화 끝

			ans = 0;
			dfs(start, times[start]);
			System.out.println(ans);
		}

		br.close();
	}

	private static void dfs(int cur, int curTime) {
		ans = Math.max(ans, curTime);

		for(int i = 0; i < nodes[cur].size(); i++) {
			int next = nodes[cur].get(i);
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, curTime + times[next]);
				visited[next] = false;
			}
		}
	}
}
