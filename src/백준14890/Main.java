package 백준14890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NL = br.readLine().split(" ");
		int N = Integer.parseInt(NL[0]);
		int L = Integer.parseInt(NL[1]);

		int[][] graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;

		for (int row = 0; row < graph.length; row++) {
			int[] cur = graph[row];
			res += getRes(L, cur);
		}

		for (int i = 0; i < graph[0].length; i++) {
			int[] cur = getCur(graph, i);
			res += getRes(L, cur);
		}

		System.out.println(res);

		br.close();
	}

	private static int getRes(int L, int[] cur) {
		boolean can = true;
		boolean[] visited = new boolean[cur.length];

		for (int i = 0; i < cur.length - 1; i++) {
			if (cur[i] == cur[i + 1]) {
				continue;
			}

			if (Math.abs(cur[i] - cur[i + 1]) >= 2) {
				can = false;
				break;
			}

			int left, right, val;
			if (cur[i] == cur[i + 1] - 1) {
				left = i - L + 1;
				right = i;
				val = cur[i];
			} else {
				left = i + 1;
				right = i + L;
				val = cur[i + 1];
			}

			boolean canPut = checkCanPut(cur, left, right, val, visited);

			if (canPut) {
				mark(left, right, visited);
			} else {
				can = false;
				break;
			}
		}

		if (can) {
			return 1;
		}
		return 0;
	}

	private static int[] getCur(int[][] graph, int i) {
		int[] cur = new int[graph.length];
		for (int j = 0; j < graph.length; j++) {
			cur[j] = graph[j][i];
		}
		return cur;
	}

	private static void mark(int left, int right, boolean[] visited) {
		for (int i = left; i <= right; i++) {
			visited[i] = true;
		}
	}

	private static boolean checkCanPut(int[] cur, int left, int right, int val, boolean[] visited) {
		if (left < 0 || right >= cur.length) {
			return false;
		}

		for (int i = left; i <= right; i++) {
			if (cur[i] != val || visited[i]) {
				return false;
			}
		}

		return true;
	}

}
