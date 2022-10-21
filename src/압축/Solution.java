package 압축;

import java.util.*;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("KAKAO");
	}

	public int[] solution(String msg) {
		Map<String, Integer> map = new HashMap<>();

		String start = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < start.length(); i++) {
			map.put(start.substring(i, i + 1), i + 1);
		}

		List<Integer> res = new ArrayList<>(); //결과 배열
		int cursor = 0, maxLen = 1, maxIndex = 26; //현재 포인터, 사전에 등재된 최대 길이, 사전에 등재된 최대 index
		while(cursor < msg.length()) {
			int endIdx = Math.min((cursor + maxLen), msg.length());
			while(endIdx > cursor) {
				String cur = msg.substring(cursor, endIdx);

				if(map.containsKey(cur)) {
					res.add(map.get(cur));
					if(endIdx < msg.length()) {
						map.put(msg.substring(cursor, endIdx + 1), maxIndex);
						maxLen = Math.max(maxLen, (endIdx - cursor + 1));
						cursor = endIdx;
						maxIndex++;
					} else {
						cursor = endIdx;
						break;
					}
				} else {
					endIdx--;
				}
			}

		}

		return res.stream().mapToInt(i -> i).toArray();
	}
}
