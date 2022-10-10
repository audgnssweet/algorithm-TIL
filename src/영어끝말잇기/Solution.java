package 영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] solution(int n, String[] words) {
		Set<String> history = new HashSet<>();

		int[] people = new int[n];

		for (int i = 0; i < words.length; i++) {
			people[i % n]++;
			String cur = words[i];
			if (history.contains(cur) || (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != cur.charAt(0))) {
				return new int[] {(i % n) + 1, people[i % n]};
			} else {
				history.add(cur);
			}
		}

		return new int[] {0, 0};
	}
}
