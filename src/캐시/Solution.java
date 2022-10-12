package 캐시;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		Set<String> cache = new HashSet<>();
		Deque<String> lru = new LinkedList<>();

		int hit = 0, miss = 0;
		for (String city : cities) {
			city = city.toLowerCase();
			if (cache.contains(city)) {
				hit++;
				lru.remove(city);
				lru.addLast(city);
			} else {
				miss++;
				lru.addLast(city);
				cache.add(city);
				if (cache.size() > cacheSize) {
					cache.remove(lru.removeFirst());
				}
			}
		}

		return hit + (miss * 5);
	}
}
