package 구명보트;

import java.util.Arrays;

class Solution {

	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int left = 0, right = people.length - 1, res = 0;
		while (left <= right) {
			if (people[left] + people[right] <= limit) {
				left++;
			}
			res++;
			right--;
		}

		return res;
	}
}
