package 행렬테두리회전하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(6, 6, new int[][] {
			{2, 2, 5, 4},
			{3, 3, 6, 6},
			{5, 1, 6, 3}
		});
	}

	static int[][] arr;

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = {};

		int k = 1;
		arr = new int[rows][columns];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				arr[y][x] = k++;
			}
		}

		List<Integer> resList = new ArrayList<>();

		for (int[] q : queries) {
			int y1 = q[0] - 1;
			int x1 = q[1] - 1;
			int y2 = q[2] - 1;
			int x2 = q[3] - 1;

			//오른쪽 회전
			int cur = arr[y1][x1];
			int res = cur;
			System.out.println("cur = " + cur);
			for (int i = 0; i < (x2 - x1); i++) {
				int next = arr[y1][x1 + i + 1];
				arr[y1][x1 + i + 1] = cur;
				cur = next;
				res = Math.min(res, cur);
			}

			//아래 회전
			for (int i = 0; i < (y2 - y1); i++) {
				int next = arr[y1 + i + 1][x2];
				arr[y1 + i + 1][x2] = cur;
				cur = next;
				res = Math.min(res, cur);
			}

			for (int i = 0; i < (x2 - x1); i++) {
				int next = arr[y2][x2 - i - 1];
				arr[y2][x2 - i - 1] = cur;
				cur = next;
				res = Math.min(res, cur);
			}

			for (int i = 0; i < (y2 - y1); i++) {
				int next = arr[y2 - i - 1][x1];
				arr[y2 - i - 1][x1] = cur;
				cur = next;
				res = Math.min(res, cur);
			}

			resList.add(res);
		}

		System.out.println(Arrays.toString(resList.toArray()));

		return resList.stream().mapToInt(i -> i).toArray();
	}

	private void print() {
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				System.out.printf("%3d", arr[y][x]);
			}
			System.out.println();
		}
	}
}
