package 튜플;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	public int[] solution(String s) {
		s = s.substring(1, s.length() - 1);

		Pattern pattern = Pattern.compile("\\{([0-9,]*)}");
		Matcher matcher = pattern.matcher(s);

		PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(String::length));
		while (matcher.find()) {
			String current = matcher.group();
			current = current.substring(1, current.length() - 1);
			pq.offer(current);
		}

		List<Integer> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		while (!pq.isEmpty()) {
			String[] split = pq.poll().split(",");
			for (String sp : split) {
				int cur = Integer.parseInt(sp);
				if (set.add(cur)) {
					res.add(cur);
				}
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}

}
