package BaekJoon14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//init metircs
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] metrics = new int[N][M];

		for (int y = 0; y < metrics.length; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < metrics[y].length; x++) {
				metrics[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		//init tetromino
		Tetromino[] tetrominos = new Tetromino[5];
		tetrominos[0] = new Tetromino(new int[] {1, 1, 1}, new int[] {0, 0, 0});
		tetrominos[1] = new Tetromino(new int[] {0, 0, 1}, new int[] {1, 1, 0});
		tetrominos[2] = new Tetromino(new int[] {0, 1, 0}, new int[] {1, 0, 1});
		tetrominos[3] = new Tetromino(new int[] {1, 1, -1}, new int[] {0, 0, 1});
		tetrominos[4] = new Tetromino(new int[] {1, 0, -1}, new int[] {0, 1, 0});

		int ans = 0;

		for (int y = 0; y < metrics.length; y++) {
			for (int x = 0; x < metrics[y].length; x++) {

				for (int idx = 0; idx < tetrominos.length; idx++) {

					for (int k = 0; k < 2; k++) {
						for (int i = 0; i < 4; i++) {
							ans = Math.max(ans, tetrominos[idx].getSum(y, x, metrics));
							tetrominos[idx].rotate();
						}
						tetrominos[idx].turn();
					}
				}
			}
		}

		System.out.println(ans);
		br.close();
	}

	static class Tetromino implements Summable, Rotatable, Turnable {

		private int[] dx;
		private int[] dy;

		public Tetromino(int[] dx, int[] dy) {
			this.dx = dx;
			this.dy = dy;
		}

		@Override
		public int getSum(int y, int x, int[][] metrics) {
			int sum = metrics[y][x];
			for (int i = 0; i < 3; i++) {
				y = y + dy[i];
				x = x + dx[i];
				if (outOfRange(x, metrics[0].length) || outOfRange(y, metrics.length)) {
					return 0;
				}
				sum += (metrics[y][x]);
			}
			return sum;
		}

		private boolean outOfRange(int pos, int maxPos) {
			if (pos < 0 || pos >= maxPos) {
				return true;
			}
			return false;
		}

		@Override
		public void rotate() {
			swapDxDy();
			swapSign(dx);
		}

		private void swapDxDy() {
			int[] temp = dx;
			dx = dy;
			dy = temp;
		}

		private void swapSign(int[] d) {
			for (int i = 0; i < d.length; i++) {
				d[i] = d[i] * -1;
			}
		}

		@Override
		public void turn() {
			swapSign(dy);
		}
	}

	interface Summable {
		int getSum(int y, int x, int[][] metrics);
	}

	interface Rotatable {
		void rotate();
	}

	interface Turnable {
		void turn();
	}

}
