package 광고삽입;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	static Map<Integer, Integer> startTimes = new HashMap<>();
	static Map<Integer, Integer> endTimes = new HashMap<>();
	static long[] res;

	public String solution(String play_time, String adv_time, String[] logs) {
		for (String log : logs) {
			//"01:20:15-01:45:14"
			String[] startEnd = log.split("-");
			int startTime = convertTimeToInt(startEnd[0]);
			int endTime = convertTimeToInt(startEnd[1]);
			startTimes.put(startTime, startTimes.getOrDefault(startTime, 0) + 1);
			endTimes.put(endTime, endTimes.getOrDefault(endTime, 0) + 1);
		}

		long curUser = 0;
		StopWatch stopWatch = new StopWatch(play_time);
		res = new long[stopWatch.targetTime + 1];
		while (!stopWatch.isEnd()) {
			curUser += startTimes.getOrDefault(stopWatch.getCurTime(), 0);
			curUser -= endTimes.getOrDefault(stopWatch.getCurTime(), 0);
			res[stopWatch.getCurTime()] = curUser;
			stopWatch.start();
		}

		for (int i = 1; i < res.length; i++) {
			res[i] = res[i - 1] + res[i];
		}

		int left = 0;
		int right = convertTimeToInt(adv_time);

		long max = 0;
		int maxTime = 0;
		while (right <= stopWatch.targetTime) {
			long curMax = res[right] - res[left];
			if (max < curMax) {
				max = curMax;
				maxTime = left;
			}
			right++;
			left++;
		}

		return convertIntToTime(maxTime == 0 ? 0 : maxTime + 1);
	}

	private String convertIntToTime(int time) {
		int hour = time / 3600;
		int minute = (time - (hour * 3600)) / 60;
		int sec = (time - (hour * 3600) - (minute * 60));

		return String.format("%02d:%02d:%02d", hour, minute, sec);
	}

	public class StopWatch {

		private final int targetTime;

		private int curTime = 0;

		public int getCurTime() {
			return curTime;
		}

		public StopWatch(String targetTime) {
			this.targetTime = convertTimeToInt(targetTime);
		}

		public boolean isEnd() {
			return curTime > targetTime;
		}

		public void start() {
			curTime++;
		}
	}

	private static int convertTimeToInt(String time) {
		String[] hourMinuteSecond = time.split(":");
		int hourInt = Integer.parseInt(hourMinuteSecond[0]) * 3600;
		int minuteInt = Integer.parseInt(hourMinuteSecond[1]) * 60;
		int secondInt = Integer.parseInt(hourMinuteSecond[2]);
		return hourInt + minuteInt + secondInt;
	}

	static String[] l = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("50:00:00", "50:00:00", l);
	}
}
