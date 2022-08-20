package toss;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public int solution(int[] tasks) {
		Map<Integer, Integer> countByNumber = new HashMap<>();
		for (int number : tasks) {
			Integer count = countByNumber.getOrDefault(number, 0);
			countByNumber.put(number, count + 1);
		}
		//2 혹은 3으로 나눠 떨어지지 않는 수가 있다면
		boolean cantDoAnything = countByNumber.values().stream()
			.anyMatch(count -> count == 1);
		//-1 리턴
		if (cantDoAnything) {
			return -1;
		}

		//그게 아니라면 최소 횟수를 구해야 하는데,
		//3보다 작을땐 1번, 6보다 작을땐 2번, 9보다 작을땐 3번 ...
		return countByNumber.values().stream()
			.mapToInt(count -> {
				if (count % 3 == 1 || count % 3 == 2) {
					return count / 3 + 1; //4 면 2 return
				} else {
					//6이면 2 return
					return count / 3;
				}
			}).sum();
	}
}
