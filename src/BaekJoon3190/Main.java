package BaekJoon3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int appleCount = Integer.parseInt(br.readLine());

		int[][] metrics = new int[N][N];
		for (int i = 0; i < appleCount; i++) {
			String[] yx = br.readLine().split(" ");
			int y = Integer.parseInt(yx[0]);
			int x = Integer.parseInt(yx[1]);
			metrics[y - 1][x - 1] = 1;
		}

		Map<Integer, String> turnMap = new HashMap<>();
		int turnCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < turnCount; i++) {
			String[] td = br.readLine().split(" ");
			int th = Integer.parseInt(td[0]);
			String dir = td[1];
			turnMap.put(th, dir);
		}

		Snake snake = new Snake();
		int moveCount = 0;
		while (true) {
			boolean result = snake.move(metrics);
			moveCount++;

			if (!result) {
				break;
			}

			if (turnMap.containsKey(moveCount)) {
				String dir = turnMap.get(moveCount);
				snake.turn(dir);
			}
		}

		System.out.println(moveCount);
		br.close();
	}

	static class Snake {

		private static int[][] dxdy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

		private Deque<int[]> pos = new LinkedList<>();
		private int dxdyInfo = 0;

		public Snake() {
			pos.add(new int[] {0, 0});
		}

		public boolean move(int[][] metrics) {
			int[] currentHeadPosition = pos.peekLast();
			int[] nextHeadPosition = getNextHeadPosition(currentHeadPosition);

			if (outOfRange(nextHeadPosition, metrics)) {
				return false;
			}
			if (isBodyCollided(nextHeadPosition)) {
				return false;
			}
			if (!hasApple(nextHeadPosition, metrics)) {
				pos.removeFirst();
			}
			metrics[nextHeadPosition[1]][nextHeadPosition[0]] = 0;

			pos.addLast(nextHeadPosition);
			return true;
		}

		private int[] getNextHeadPosition(int[] headPos) {
			return new int[] {headPos[0] + dxdy[dxdyInfo][0], headPos[1] + dxdy[dxdyInfo][1]};
		}

		private boolean outOfRange(int[] pos, int[][] metrics) {
			if (pos[0] >= metrics[0].length || pos[0] < 0 || pos[1] >= metrics.length || pos[1] < 0) {
				return true;
			}
			return false;
		}

		private boolean isBodyCollided(int[] nextHeadPosition) {
			return pos.stream()
				.anyMatch(bodyPos -> bodyPos[0] == nextHeadPosition[0] && bodyPos[1] == nextHeadPosition[1]);
		}

		private boolean hasApple(int[] pos, int[][] metrics) {
			if (metrics[pos[1]][pos[0]] == 1) {
				return true;
			}
			return false;
		}

		public void turn(String dir) {
			if (dir.equals("D")) {
				dxdyInfo = (dxdyInfo + 1) > 3 ? 0 : dxdyInfo + 1;
			}
			if (dir.equals("L")) {
				dxdyInfo = (dxdyInfo - 1) < 0 ? 3 : dxdyInfo - 1;
			}
		}
	}
}
