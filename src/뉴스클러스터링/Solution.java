package 뉴스클러스터링;

import java.util.*;
import java.util.regex.*;

class Solution {
	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		PriorityQueue<String> pq1 = new PriorityQueue<>();
		for(int i = 0; i < str1.length() - 1; i++) {
			String cur = str1.substring(i, i + 2).replaceAll("[^a-z]", "");
			if(cur.length() == 2) {
				pq1.offer(str1.substring(i, i + 2));
			}
		}

		PriorityQueue<String> pq2 = new PriorityQueue<>();
		for(int i = 0; i < str2.length() - 1; i++) {
			String cur = str2.substring(i, i + 2).replaceAll("[^a-z]", "");
			if(cur.length() == 2) {
				pq2.offer(str2.substring(i, i + 2));
			}
		}

		int intersection = 0;
		int union = 0;
		while(!pq1.isEmpty() && !pq2.isEmpty()) {
			int compare = pq1.peek().compareTo(pq2.peek());
			if(compare == 0) {
				intersection++;
				union++;
				pq1.poll();
				pq2.poll();
			} else if (compare < 0) {
				union++;
				pq1.poll();
			} else {
				union++;
				pq2.poll();
			}
		}

		if(!pq1.isEmpty()) {
			union += pq1.size();
		}
		if(!pq2.isEmpty()) {
			union += pq2.size();
		}

		if(union == 0) {
			return 65536;
		}

		return (int)Math.floor(((double) intersection / union) * 65536);
	}
}
