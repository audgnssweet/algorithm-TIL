package toss;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
	public int solution(String s) {
		int answer = 0;

		//s 를 탐색하면서 숫자 3개가 반복되는 것을 전부 찾는다.

		//길이가 3보다 짧기 때문에 -1 return
		if (s.length() < 3) {
			return -1;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		Deque<Character> stack = new LinkedList<>();
		//하나씩 순회 하면서
		for (char c : s.toCharArray()) {
			//스택이 비어있지 않고, 스택의 마지막꺼가 c 가 아니라면 계속 꺼낸다.
			while (!stack.isEmpty() && stack.peekLast() != c) {
				stack.pollLast();
			}
			stack.addLast(c);
			//크기가 3이면 다 꺼내서, 집어넣는다.
			if (stack.size() == 3) {
				String result = "" + stack.pop() + stack.pop() + stack.pop();
				if (result.equals("000")) {
					result = "0";
				}
				pq.offer(Integer.parseInt(result));
			}
		}

		//없으면 -1 을 return 한다.
		if (pq.isEmpty()) {
			return -1;
		}
		return pq.poll();
	}
}
