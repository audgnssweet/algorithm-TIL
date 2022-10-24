package 백준1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] VE = br.readLine().split(" ");
		int V = Integer.parseInt(VE[0]);
		int E = Integer.parseInt(VE[1]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.offer(new int[] {l, r, w});
		}

		parents = new int[V + 1];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}

		int res = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int l = cur[0];
			int r = cur[1];
			int w = cur[2];

			int lPar = findParent(l);
			int rPar = findParent(r);

			if (lPar == rPar) {
				continue;
			}

			int newPar = Math.min(lPar, rPar);
			parents[lPar] = newPar;
			parents[rPar] = newPar;

			res += w;
		}

		System.out.println(res);

		br.close();
	}

	private static int findParent(int i) {
		if (parents[i] == i) {
			return i;
		} else {
			parents[i] = findParent(parents[i]);
			return parents[i];
		}
	}
}
