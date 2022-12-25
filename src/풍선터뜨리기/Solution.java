package 풍선터뜨리기;

import java.util.TreeSet;

public class Solution {
	public int solution(int[] a) {
		int answer = 0;

		TreeSet<Integer> lts = new TreeSet<>((i1, i2) -> i1 - i2);
		TreeSet<Integer> rts = new TreeSet<>((i1, i2) -> i1 - i2);
		for (int i = 0; i < a.length; i++) {
			rts.add(a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			rts.remove(a[i]);
			if (lts.isEmpty() || rts.isEmpty() || lts.first() > a[i] || rts.first() > a[i]) {
				answer++;
			}
			lts.add(a[i]);
		}

		return answer;
	}
}
