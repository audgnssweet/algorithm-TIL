package 베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	class Node {
		int idx;
		int cnt;

		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> cntByGenre = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			cntByGenre.put(genres[i], cntByGenre.getOrDefault(genres[i], 0) + plays[i]);
		}

		Map<String, PriorityQueue<Node>> nodeByGenre = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			PriorityQueue<Node> pq = nodeByGenre.getOrDefault(genres[i],
				new PriorityQueue<>((n1, n2) -> n2.cnt - n1.cnt));
			pq.offer(new Node(i, plays[i]));
			nodeByGenre.put(genres[i], pq);
		}

		List<Integer> res = new ArrayList<>();

		cntByGenre.entrySet()
			.stream()
			.sorted((e1, e2) -> e2.getValue() - e1.getValue())
			.forEach(e -> {
				PriorityQueue<Node> pq = nodeByGenre.get(e.getKey());
				Node node = pq.poll();

				res.add(node.idx);

				if (!pq.isEmpty()) {
					res.add(pq.poll().idx);
				}
			});

		return res.stream().mapToInt(i -> i).toArray();
	}
}
