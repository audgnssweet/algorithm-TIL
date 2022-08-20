package kakao2022intern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		Q q1 = new Q(queue1);
		Q q2 = new Q(queue2);

		if ((q1.sum() + q2.sum()) % 2 != 0) {
			return -1;
		}

		int limit = (queue1.length + queue2.length) * 2;
		int cnt = 0;
		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (cnt >= limit) {
				break;
			}

			if (q1.sum() == q2.sum()) {
				return cnt;
			}

			if (q1.sum() > q2.sum()) {
				q2.offer(q1.poll());
			} else {
				q1.offer(q2.poll());
			}
			cnt++;
		}

		return -1;
	}

	static class Q {
		private Queue<Integer> q;
		private long sum;

		public Q(int[] arr) {
			this.sum = sum(arr);
			this.q = getQueue(arr);
		}

		public long sum() {
			return this.sum;
		}

		public boolean isEmpty() {
			return this.q.isEmpty();
		}

		public void offer(int n) {
			this.q.offer(n);
			this.sum += n;
		}

		public int poll() {
			if (isEmpty()) {
				throw new RuntimeException("큐가 비어있음");
			}
			int first = q.poll();
			sum -= first;
			return first;
		}

		private long sum(int[] arr) {
			return Arrays.stream(arr)
				.mapToLong(Long::valueOf)
				.sum();
		}

		private LinkedList<Integer> getQueue(int[] queue1) {
			return Arrays.stream(queue1)
				.boxed()
				.collect(Collectors.toCollection(LinkedList::new));
		}
	}
}
