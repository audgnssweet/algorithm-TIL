package 파괴되지않은건물;

public class Solution {
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;

		int y = board.length + 1;
		int x = board[0].length + 1;

		int[][] res = new int[y][x];
		for (int[] s : skill) {
			int multiply = s[0] == 1 ? -1 : 1;
			int set = s[5] * multiply;

			res[s[1]][s[2]] += set;
			res[s[1]][s[4] + 1] -= set;
			res[s[3] + 1][s[4] + 1] += set;
			res[s[3] + 1][s[2]] -= set;
		}

		for (int i = 0; i < res.length; i++) {
			for (int j = 1; j < res[i].length; j++) {
				res[i][j] += res[i][j - 1];
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 1; j < y; j++) {
				res[j][i] += res[j - 1][i];
			}
		}

		for (int i = 0; i < y - 1; i++) {
			for (int j = 0; j < x - 1; j++) {
				if (res[i][j] + board[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}
