package BaekJoon2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ST = br.readLine().split(" ");
		int S = Integer.parseInt(ST[0]);
		int T = Integer.parseInt(ST[1]);

		int[] sun = new int[S + 1];

		List<Integer>[] nexts = new ArrayList[S + 1];
		for (int i = 1; i < nexts.length; i++) {
			nexts[i] = new ArrayList<>();
		}

		for (int i = 0; i < T; i++) {
			String[] FB = br.readLine().split(" ");
			int F = Integer.parseInt(FB[0]);
			int B = Integer.parseInt(FB[1]);

			nexts[F].add(B);
			sun[B]++;
		}



		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < sun.length; i++) {
			if (sun[i] == 0) {
				q.offer(i);
			}
		}

		List<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);

			for (int next : nexts[cur]) {
				sun[next]--;
				if (sun[next] == 0) {
					q.offer(next);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int s : res) {
			sb.append(s).append(' ');
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb);

		br.close();
	}
}
