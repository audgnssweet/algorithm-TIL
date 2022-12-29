package 기둥과보설치;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	boolean[][] g;
	boolean[][] b;

	final int BO = 1;
	final int GIDOONG = 0;

	final int DES = 0;
	final int INS = 1;

	public int[][] solution(int n, int[][] build_frame) {
		int[][] answer = {};

		g = new boolean[n + 1][n + 1];
		b = new boolean[n + 1][n + 1];

		for (int[] bf : build_frame) {
			set(bf);
			if (!can(bf)) {
				unset(bf);
			}
		}

		List<int[]> res = new ArrayList<>();
		for (int x = 0; x <= n; x++) {
			for (int y = 0; y <= n; y++) {
				if (g[x][y]) {
					res.add(new int[] {x, y, GIDOONG});
				}
				if (b[x][y]) {
					res.add(new int[] {x, y, BO});
				}
			}
		}

		return res.stream()
			.sorted((a1, a2) -> {
				if (a1[0] != a2[0]) {
					return a1[0] - a2[0];
				}
				if (a1[1] != a2[1]) {
					return a1[1] - a2[1];
				}
				return a1[2] - a2[2];
			})
			.toArray(int[][]::new);

	}

	void set(int[] bf) {
		if (bf[2] == GIDOONG && bf[3] == INS) {
			g[bf[0]][bf[1]] = true;
		}
		if (bf[2] == GIDOONG && bf[3] == DES) {
			g[bf[0]][bf[1]] = false;
		}
		if (bf[2] == BO && bf[3] == INS) {
			b[bf[0]][bf[1]] = true;
		}
		if (bf[2] == BO && bf[3] == DES) {
			b[bf[0]][bf[1]] = false;
		}
	}

	void unset(int[] bf) {
		if (bf[2] == GIDOONG && bf[3] == INS) {
			g[bf[0]][bf[1]] = false;
		}
		if (bf[2] == GIDOONG && bf[3] == DES) {
			g[bf[0]][bf[1]] = true;
		}
		if (bf[2] == BO && bf[3] == INS) {
			b[bf[0]][bf[1]] = false;
		}
		if (bf[2] == BO && bf[3] == DES) {
			b[bf[0]][bf[1]] = true;
		}
	}

	boolean can(int[] bf) {
		if (bf[3] == INS) {
			return bf[2] == BO ? canBo(bf[0], bf[1]) : canGidoong(bf[0], bf[1]);
		}

		for (int x = 0; x < g[0].length; x++) {
			for (int y = 0; y < g.length; y++) {
				if (g[x][y] && !canGidoong(x, y)) {
					return false;
				}
				if (b[x][y] && !canBo(x, y)) {
					return false;
				}
			}
		}

		return true;
	}

	boolean canBo(int x, int y) {
		return (y > 0 && g[x][y - 1]) ||
			(y > 0 && g[x + 1][y - 1]) ||
			(x > 0 && b[x - 1][y] && b[x + 1][y]);
	}

	boolean canGidoong(int x, int y) {
		return y == 0 ||
			b[x][y] ||
			(x > 0 && b[x - 1][y]) ||
			(y > 0 && g[x][y - 1]);
	}
}