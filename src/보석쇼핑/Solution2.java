package 보석쇼핑;

import java.util.*;

class Solution2 {
	public int[] solution(String[] gems) {
		int[] res = {1, 1};
		int min = Integer.MAX_VALUE;

		Set<String> set = new HashSet<>();
		for(String g : gems) {
			set.add(g);
		}

		Map<String, Integer> map = new HashMap<>();

		int left = 0, right = 0;
		while(right < gems.length) {
			String cur = gems[right];
			if(map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			} else {
				map.put(cur, 1);
			}

			if(map.size() == set.size()) {
				while(map.get(gems[left]) > 1) {
					map.put(gems[left], map.get(gems[left]) - 1);
					left++;
				}

				if(right - left + 1 < min) {
					min = (right - left + 1);
					res[0] = left + 1;
					res[1] = right + 1;
				}
			}

			right++;
		}

		return res;
	}
}
