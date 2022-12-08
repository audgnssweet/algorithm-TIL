package kti23;

public class Solution {

	public int[] solution(String logs) {
		int[] res = new int[24];
		for(String log : logs.split("\n")) {
			String time = log.split(" ")[1];
			String[] hms = time.split(":");

			int h = Integer.parseInt(hms[0]);
			h = (h + 9) % 24;

			res[h]++;
		}

		return res;
	}
}
