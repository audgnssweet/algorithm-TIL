package 단속카메라;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public int solution(int[][] routes) {
		Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
		int ans = 0;
		int last_camera = Integer.MIN_VALUE;
		for (int[] a : routes) {
			if (last_camera < a[0]) {
				++ans;
				last_camera = a[1];
			}
		}
		return ans;
	}
}
