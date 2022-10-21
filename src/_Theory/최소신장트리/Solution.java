package _Theory.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] VE = br.readLine().split(" ");
		int V = Integer.parseInt(VE[0]);
		int E = Integer.parseInt(VE[1]);

		parents = new int[V + 1];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
		for (int i = 0; i < E; i++) {
			String[] SEW = br.readLine().split(" ");
			int start = Integer.parseInt(SEW[0]);
			int end = Integer.parseInt(SEW[1]);
			int weight = Integer.parseInt(SEW[2]);

			pq.offer(new int[] {start, end, weight});
		}

		int res = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			int startParent = findParent(cur[0]);
			int endParent = findParent(cur[1]);

			if (startParent == endParent) {
				continue;
			}

			int min = Math.min(startParent, endParent);
			//여기 주의! 루트의 부모를 바꿔줘야 한다. 안그럼 또 고르는 문제 생김
			parents[startParent] = min;
			parents[endParent] = min;
			res += cur[2];
		}

		System.out.println(res);

		br.close();
	}

	private static int findParent(int i) {
		if (i == parents[i]) {
			return i;
		} else {
			parents[i] = findParent(parents[i]);
			return parents[i];
		}
	}
}
