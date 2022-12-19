package 징검다리건너기;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

	class Data {
		int value;
		int idx;

		public Data(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}
	}

	int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;

		Deque<Data> q = new ArrayDeque<>();
		for (int i = 0; i < stones.length; i++) {
			int cur = stones[i];

			//index <= i - k 라는건, 현재 위치에서 길이 판단에 전혀 관련이 없는 노드기 때문에 빼버리는 것
			if (!q.isEmpty() && q.peek().idx <= i - k) {
				q.pollFirst();
			}
			//큐에 들어있는 것들이 현재 값보다 작은 경우 빼버린다. -> 스택처럼 사용하는 것
			while (!q.isEmpty() && q.peekLast().value <= cur) {
				q.pollLast();
			}
			q.add(new Data(cur, i));
			if (answer > q.peek().value && i >= k - 1) {
				answer = q.peek().value;
			}
		}

		return answer;
	}
}
