package javis;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		solution4.solution(3, new int[][] {{1, 4}, {2, 2}, {1, 3}, {1, 6}, {3, -1}, {2, -1}});
	}

	public int[] solution(int n, int[][] queries) {
		CircularStack circularStack = new CircularStack(n);
		for (int[] q : queries) {
			int target = q[0];
			int num = q[1];
			if (num > 0) {
				circularStack.push(target - 1, num);
			} else {
				res.add(circularStack.pop(target - 1));
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}

	static class CircularStack {
		int mid;
		Deque<Integer>[] stack;

		public CircularStack(int n) {
			mid = -1;
			stack = new LinkedList[n];
			for (int i = 0; i < stack.length; i++) {
				stack[i] = new LinkedList<>();
			}
		}

		public void push(int i, int k) {
			if (isMidEmpty()) {
				mid = k;
			} else {
				stack[i].addLast(k);
			}
		}

		public Integer pop(int i) {
			if (!stack[i].isEmpty()) {
				return stack[i].pollLast();
			}
			//중앙도 비어있으면 -1 반환
			if (isMidEmpty()) {
				return mid;
			}
			//중앙이 비어있지 않으면, 시계방향으로 땡겨오고 중앙 반환
			int pop = mid;
			mid = -1;

			int next = getNextStackPos(i, i);
			if (next != i) {
				mid = stack[next].pollFirst();
			}

			return pop;
		}

		public int getNextStackPos(int i, int start) {
			int next = (i + 1) % (stack.length);
			if (next == start) {
				return next;
			} else {
				if (stack[next].isEmpty()) {
					return getNextStackPos(next, start);
				} else {
					return next;
				}
			}
		}

		public boolean isMidEmpty() {
			return mid == -1;
		}
	}
}
