package 백준14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	static LinkedList<Integer>[] gears = new LinkedList[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < gears.length; i++) {
			gears[i] = new LinkedList<>();
		}

		for (int i = 0; i < 4; i++) {
			for (String str : br.readLine().split("")) {
				gears[i].addLast(Integer.parseInt(str));
			}
		}

		int rotateCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < rotateCnt; i++) {
			String[] idxDir = br.readLine().split(" ");
			int idx = Integer.parseInt(idxDir[0]) - 1;
			int dir = Integer.parseInt(idxDir[1]);

			int[] rotate = new int[4];
			rotate[idx] = dir;
			int left = idx - 1, right = idx + 1;
			while (left >= 0) {
				rotate[left] = getRotateDir(left, left + 1, rotate);
				left--;
			}
			while (right < 4) {
				rotate[right] = getRotateDir(right - 1, right, rotate);
				right++;
			}

			for (int r = 0; r < rotate.length; r++) {
				rotate(gears[r], rotate[r]);
			}
		}

		int res = 0;
		for (int i = 0; i < gears.length; i++) {
			int cur = gears[i].getFirst();
			res += (cur == 1) ? Math.pow(2, i) : 0;
		}

		System.out.println(res);

		br.close();
	}

	private static int getRotateDir(int left, int right, int[] rotate) {
		if (rotate[left] == 0 && rotate[right] == 0) {
			return 0;
		} else if (gears[left].get(2) == gears[right].get(6)) {
			return 0;
		} else {
			if (rotate[left] != 0) {
				return rotate[left] == -1 ? 1 : -1;
			} else {
				return rotate[right] == -1 ? 1 : -1;
			}
		}
	}

	private static void rotate(LinkedList<Integer> gear, int dir) {
		if (dir == 1) {
			rotateClock(gear);
		} else if (dir == -1) {
			rotateReverseClock(gear);
		}
	}

	private static void rotateClock(LinkedList<Integer> gear) {
		gear.addFirst(gear.removeLast());
	}

	private static void rotateReverseClock(LinkedList<Integer> gear) {
		gear.addLast(gear.removeFirst());
	}
}
