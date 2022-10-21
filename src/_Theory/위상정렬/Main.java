package _Theory.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		List<Integer>[] graph = new List[N + 1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		int[] arr = new int[N + 1];
		for (int i = 0; i < M; i++) {
			String[] SE = br.readLine().split(" ");
			int S = Integer.parseInt(SE[0]);
			int E = Integer.parseInt(SE[1]);

			arr[E]++;
			graph[S].add(E);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				q.offer(i);
			}
		}

		List<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			Integer cur = q.poll();
			res.add(cur);
			for (int next : graph[cur]) {
				arr[next]--;
				if (arr[next] == 0) {
					q.offer(next);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int n : res) {
			sb.append(n).append(' ');
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb);

		br.close();
	}
}
