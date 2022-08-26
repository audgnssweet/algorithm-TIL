package ranking;

import java.util.Arrays;

public class OtherSolution {

	static int[][] res;

	public int solution(int n, int[][] results) {
		res = new int[n][n];
		for (int[] winnerLoser : results) {
			int winner = winnerLoser[0];
			int loser = winnerLoser[1];

			res[winner - 1][loser - 1] = 1;
			res[loser - 1][winner - 1] = -1;
		}

		//거쳐가는 노드
		for (int k = 0; k < 4; k++) {
			//출발 노드
			for (int i = 0; i < 4; i++) {
				//도착 노드
				for (int j = 0; j < 4; j++) {
					if (res[i][j] == 0 && i != j) {
						if (res[i][k] == 1 && res[k][j] == 1) {
							res[i][j] = 1;
						} else if (res[i][k] == -1 && res[k][j] == -1) {
							res[i][j] = -1;
						}
					}
				}
			}
		}

		int cnt = 0;
		for(int[] player: res) {
			int tmp = 0;
			for(int next: player) {
				if (next != 0) {
					tmp++;
				}
			}
			if (tmp == n - 1) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		OtherSolution o = new OtherSolution();
		o.solution()
	}
}
