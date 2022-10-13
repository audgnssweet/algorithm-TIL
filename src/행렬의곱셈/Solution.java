package 행렬의곱셈;

class Solution {

	static int[][] res;
	static int[][] arr1;
	static int[][] arr2;

	public int[][] solution(int[][] arr1, int[][] arr2) {
		res = new int[arr1.length][arr2[0].length];
		Solution.arr1 = arr1;
		Solution.arr2 = arr2;
		for (int y = 0; y < res.length; y++) {
			for (int x = 0; x < res[y].length; x++) {
				res[y][x] = getValue(y, x);
			}
		}
		return res;
	}

	private int getValue(int y, int x) {
		int value = 0;
		for (int i = 0; i < arr1[y].length; i++) {
			value += (arr1[y][i] * arr2[i][x]);
		}
		return value;
	}
}
