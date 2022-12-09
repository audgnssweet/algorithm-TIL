package 최고의집합;

public class Solution {

	public int[] solution(int n, int s) {
		if (s < n) {
			return new int[] {-1};
		}

		int cnt = 0;
		while (s % n != 0) {
			s--;
			cnt++;
		}

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s / n;
		}

		int idx = arr.length - 1;
		while (cnt > 0) {
			arr[idx--]++;
			cnt--;
		}

		return arr;
	}
}
