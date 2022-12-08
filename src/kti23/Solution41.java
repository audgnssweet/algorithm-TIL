package kti23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution41 {
	public int[] solution(int[][] jobs) {
		int[] answer = {};

		Task.NullTask nullTask = new Task.NullTask();
		Task curTask = nullTask;

		PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> {
			if (t1.priority != t2.priority) { //중요도 높은 것부터 꺼냄
				return t2.priority - t1.priority;
			}
			return t1.category - t2.category; //중요도 같다면 범주가 작은 것부터 꺼냄
		});
		Map<Integer, Task> map = new HashMap<>();

		//0 -> 요청시간, 1 -> 처리시간, 2 -> 분류번호, 3 -> 중요도
		List<Integer> res = new ArrayList<>();
		int pos = 0, curTime = 0;
		while (pos < jobs.length) {

			int[] job = jobs[pos];

			if (job[0] == curTime) { //task 가 대기열에 등록되어야 한다면

				//이미 대기열에 등록된 범주의 task 라면, 중요도와 처리 시간만 추가
				if (map.containsKey(job[2])) {

					Task task = map.get(job[2]);
					pq.remove(task);

					task.priority += job[3];
					task.duration += job[1];
					pq.offer(task);


				} else { //대기열에 등록되지 않은 task 라면 대기열에 등록

					Task task = new Task(job[2], job[3], job[1]);
					map.put(job[2], task);
					pq.offer(task);

				}

				pos++;
			}


			curTask.doTask();
			if (curTask.isEnd()) { //현재 진행중인 작업이 끝났다면


				if (map.containsKey(curTask.category)) { //지금 진행중인 작업과 같은 카테고리의 작업 있으면 그것부터 하기

					curTask = map.remove(curTask.category);
					pq.remove(curTask);
				} else if (!pq.isEmpty()) { //대기중인 작업이 있다면

					Task task = pq.poll();
					curTask = task;
					map.remove(task.category);

					if (res.isEmpty() || res.get(res.size() - 1) != task.getCategory()) {
						res.add(task.getCategory());
					}


				} else { //대기중인 작업이 없다면

					curTask = nullTask;
				}

			}

			curTime++;

		}

		while (!pq.isEmpty()) {
			Task task = pq.poll();
			res.add(task.getCategory());
		}

		return res.stream().mapToInt(i -> i).toArray();
	}

	static class Task {
		int category;
		int priority;
		int duration;

		protected Task() {
		}

		public Task(int category, int priority, int duration) {
			this.category = category;
			this.priority = priority;
			this.duration = duration;
		}

		public boolean isEnd() {
			return duration == 0;
		}

		public void doTask() {
			duration = duration == 0 ? 0 : duration - 1;
		}

		public int getCategory() {
			return this.category;
		}

		@Override
		public boolean equals(Object o) {
			if(o == null || !o.getClass().equals(getClass())) {
				return false;
			}
			Task other = (Task) o;
			return category == other.category &&
				priority == other.priority &&
				duration == other.duration;
		}

		@Override
		public int hashCode() {
			return Objects.hash(category, priority, duration);
		}

		static class NullTask extends Task {

			public NullTask() {
				super();
			}

			@Override
			public boolean isEnd() {
				return true;
			}

			@Override
			public int getCategory() {
				return 0;
			}

			@Override
			public void doTask() {
			}

			@Override
			public boolean equals(Object o) {
				return super.equals(o);
			}

			@Override
			public int hashCode() {
				return super.hashCode();
			}
		}
	}
}

