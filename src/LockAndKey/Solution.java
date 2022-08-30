package LockAndKey;

public class Solution {

	static int[][] arr;
	static int start;
	static int end;
	static int len;
	static int gap;
	static int keys[][];
	static int temp[][];

	public boolean solution(int[][] key, int[][] lock) {
		len = lock.length + (key.length - 1) * 2;
		start = key.length - 1;
		end = key.length + lock.length - 2;
		gap = key.length - 1;
		keys = key;

		for (int dir = 0; dir < 4; dir++) {
			turn();
			for (int y = 0; y <= (key.length + lock.length - 2); y++) {
				for (int x = 0; x <= (key.length + lock.length - 2); x++) {
					init(key, lock);
					fill(y, x);
					if (isEnd()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private void turn() {
		temp = new int[keys.length][keys.length];
		for (int y = 0; y < keys.length; y++) {
			for (int x = 0; x < keys.length; x++) {
				temp[x][keys.length - 1 - y] = keys[y][x];
			}
		}
		keys = temp;
	}

	private void fill(int yStart, int xStart) {
		for (int y = yStart; y <= yStart + gap; y++) {
			for (int x = xStart; x <= xStart + gap; x++) {
				arr[y][x] += keys[y - yStart][x - xStart];
			}
		}
	}

	private boolean isEnd() {
		for (int y = start; y <= end; y++) {
			for (int x = start; x <= end; x++) {
				if (arr[y][x] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private void init(int[][] key, int[][] lock) {
		arr = new int[len][len];
		for (int y = 0; y < lock.length; y++) {
			for (int x = 0; x < lock.length; x++) {
				arr[y + gap][x + gap] = lock[y][x];
			}
		}
	}
}
