package BaekJoon16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int day;
	private static boolean changed;

	private static int N;
	private static int min;
	private static int max;

	private static int[][] matrics;
	private static boolean[][] visited;

	private static int[] dy = {0, 1, 0, -1};
	private static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		N = Integer.parseInt(firstLine[0]);
		min = Integer.parseInt(firstLine[1]);
		max = Integer.parseInt(firstLine[2]);

		matrics = new int[N][N]; //matrics -> 0 부터 시작
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				matrics[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		//초기화 끝

		while (true) {
			visited = new boolean[N][N];

			//여기로 돌아와야함
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {

					if (visited[y][x]) {
						continue;
					}

					List<int[]> nodes = new ArrayList<>();
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {y, x});
					visited[y][x] = true;

					int sum = 0;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int curY = cur[0];
						int curX = cur[1];

						nodes.add(cur);
						sum += matrics[curY][curX];

						for (int i = 0; i < 4; i++) {
							int nextY = curY + dy[i];
							int nextX = curX + dx[i];

							if (outOfRange(nextY, nextX) || visited[nextY][nextX]) {
								continue;
							}

							int gap = Math.abs(matrics[curY][curX] - matrics[nextY][nextX]);
							if (gapOutOfRange(gap)) {
								continue;
							}

							q.offer(new int[] {nextY, nextX});
							visited[nextY][nextX] = true;
						}
					}

					if (nodes.size() > 1) {
						int newValue = sum / nodes.size();

						for (int[] node : nodes) {
							int yy = node[0];
							int xx = node[1];

							matrics[yy][xx] = newValue;
						}
						changed = true;
					}
				}
			}

			if (changed) {
				day++;
				changed = false;
			} else {
				break;
			}
		}

		System.out.println(day);

		br.close();
	}

	private static boolean outOfRange(int y, int x) {
		return y < 0 || y >= matrics.length || x < 0 || x >= matrics[y].length;
	}

	private static boolean gapOutOfRange(int gap) {
		return gap < min || gap > max;
	}
}
