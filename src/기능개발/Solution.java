package 기능개발;

import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {

		int[] needDays = new int[progresses.length];
		for(int i = 0; i < progresses.length; i++) {
			int next = progresses[i];
			int speed = speeds[i];

			int needDay = 0;
			while(next + (speed * needDay) < 100) {
				needDay++;
			}

			needDays[i] = needDay;
		}

		List<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < needDays.length; i++) {
			if(!q.isEmpty() && q.peek() >= needDays[i]) {
				q.offer(needDays[i]);
			} else {
				if(!q.isEmpty()) {
					res.add(q.size());
					q.clear();
				}
				q.offer(needDays[i]);
			}
		}

		res.add(q.size());

		return res.stream().mapToInt(i -> i).toArray();
	}
}
