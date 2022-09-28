package line;

public class Solution3 {

	static int[][] fires;
	static int[][] ices;
	static int m;

	public long[][] solution(int n, int m, int[][] fires, int[][] ices) {
		Solution3.fires = fires;
		Solution3.ices = ices;
		Solution3.m = m;

		long[][] res = new long[n][n];

		for (int y = 0; y < res.length; y++) {
			for (int x = 0; x < res[y].length; x++) {
				res[y][x] = getCnt(x, y);
			}
		}
		return res;
	}

	private long getCnt(int x, int y) {
		long res = 0;

		for (int[] fire : fires) {
			int fireX = fire[1] - 1;
			int fireY = fire[0] - 1;

			int xDiff = Math.abs(x - fireX);
			int yDiff = Math.abs(y - fireY);

			int max = Math.max(xDiff, yDiff);
			max = max == 0 ? 1 : max;

			if (max <= m) {
				res += (m - max + 1);
			}
		}

		for (int[] ice : ices) {
			int iceY = ice[0] - 1;
			int iceX = ice[1] - 1;

			int xDiff = Math.abs(x - iceX);
			int yDiff = Math.abs(y - iceY);

			int diff = xDiff + yDiff;
			diff = diff == 0 ? 1 : diff;

			if (diff <= m) {
				res -= (m - diff + 1);
			}
		}

		return res;
	}
}
