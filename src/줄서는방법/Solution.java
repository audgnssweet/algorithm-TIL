package 줄서는방법;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public int[] solution(int n, long k) {
		//1 -> 1
		//2 -> 2
		//3 -> 6
		//4 -> 24
		//5 -> 24 * 5
		int[] res = new int[n];
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		long size = 1;
		for (int i = 2; i <= n; i++) {
			size *= i;
		}

		int idx = 0;
		while (idx < res.length) {
			long partition = size / n;
			int temp = 1;
			while (partition * temp < k) {
				temp++;
			}

			res[idx++] = nums.remove(temp - 1);

			size = partition;
			n -= 1;
			k -= (partition * (temp - 1));
		}

		return res;
	}

}
