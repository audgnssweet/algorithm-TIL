package 야근지수;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

	public long solution(int n, int[] works) {
		pq.addAll(
			Arrays.stream(works)
				.boxed()
				.collect(Collectors.toList()));

		while (n > 0) {
			Integer max = pq.poll();
			if (max == 0) {
				return 0;
			}
			max -= 1;
			pq.offer(max);
			n--;
		}

		return pq.stream()
			.mapToLong(it -> (long)it * it)
			.sum();
	}
}
