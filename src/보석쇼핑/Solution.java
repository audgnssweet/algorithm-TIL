package 보석쇼핑;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {

	public int[] solution(String[] gems) {
		int len = 100_001;
		int[] res = new int[2];

		HashSet<String> set = new HashSet<>(Arrays.asList(gems));
		HashSet<String> tmp = new HashSet<>();

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.idx));
		for (int i = 0; i < gems.length; i++) {
			if (!pq.isEmpty() && pq.peek().j.equals(gems[i])) {
				pq.poll();
			}
			pq.offer(new Node(gems[i], i)); //이 알고리즘의 문제 = 최소 노드가 아니면 삭제가 안된다
			tmp.add(gems[i]);
			if (tmp.size() == set.size()) {
				int curLen = i - pq.peek().idx;
				if (curLen < len) {
					len = curLen;
					res[0] = pq.peek().idx;
					res[1] = i;
				}
			}
		}

		return res;
	}

	static class Node {
		String j;
		int idx;

		public Node(String j, int idx) {
			this.j = j;
			this.idx = idx;
		}
	}
}
