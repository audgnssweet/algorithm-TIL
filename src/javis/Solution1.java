package javis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1 {

	public int[] solution(String[] students) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
			if (a1[1] == a2[1]) {
				return a1[0] - a2[0];
			} else {
				return a2[1] - a1[1];
			}
		});

		for (int i = 0; i < students.length; i++) {
			Map<Character, Integer> numberByCharacter = new HashMap<>();
			for (char c : students[i].toCharArray()) {
				numberByCharacter.put(c, numberByCharacter.getOrDefault(c, 0) + 1);
			}

			int res = 10;
			int a = numberByCharacter.getOrDefault('A', 0);
			int l = numberByCharacter.getOrDefault('L', 0);
			int p = numberByCharacter.getOrDefault('P', 0);
			while (l >= 2) {
				l -= 2;
				p += 1;
			}

			res += a;
			if (p >= 3) {
				res = 0;
			} else {
				res -= p;
			}

			pq.offer(new int[] {i + 1, res});
		}

		List<Integer> resStudents = new ArrayList<>();
		while (!pq.isEmpty()) {
			resStudents.add(pq.poll()[0]);
		}

		return resStudents.stream().mapToInt(i -> i).toArray();
	}
}
