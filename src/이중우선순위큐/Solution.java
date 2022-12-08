package 이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minq = new PriorityQueue<>();

		for (String op : operations) {
			String[] CN = op.split(" ");
			int number = Integer.parseInt(CN[1]);

			if (CN[0].equals("I")) {
				maxq.offer(number);
				minq.offer(number);
				continue;
			}

			if (maxq.isEmpty()) {
				continue;
			}

			if (number == 1) {
				Integer max = maxq.poll();
				minq.remove(max);
			} else {
				Integer min = minq.poll();
				maxq.remove(min);
			}
		}

		if (maxq.isEmpty()) {
			return new int[] {0, 0};
		}

		return new int[] {maxq.peek(), minq.peek()};
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(new String[] {});
	}
}
