package 섬연결하기;

import java.util.Arrays;

public class Solution {
	public int solution(int n, int[][] costs) {
		int answer = 0;

		int[] parents = new int[n];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		Arrays.sort(costs, (a1, a2) -> a1[2] - a2[2]);
		for (int[] node : costs) {
			int left = node[0];
			int right = node[1];
			int weight = node[2];

			int leftParent = findParent(left, parents);
			int rightParent = findParent(right, parents);

			if (leftParent == rightParent) {
				continue;
			}

			int parent = Math.min(leftParent, rightParent);

			parents[leftParent] = parents[rightParent] = parent;

			answer += weight;
		}

		return answer;
	}

	int findParent(int cur, int[] parents) {
		if (cur == parents[cur]) {
			return cur;
		}
		return (parents[cur] = findParent(parents[cur], parents));
	}
}
