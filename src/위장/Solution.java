package 위장;

import java.util.*;

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		for(String[] cloth : clothes) {
			String category = cloth[1];
			map.put(category, map.getOrDefault(category, 0) + 1);
		}

		int res = 1;
		for(int val : map.values()) {
			System.out.println(val);
			res *= (val + 1);
		}

		return res - 1;
	}
}
