package 방문길이;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	static List<Integer> ctls = new ArrayList<>();

	public int solution(String dirs) {
		makeControls(dirs);

		int res = 0;
		Set<Pos> history = new HashSet<>();
		int[] cur = {0, 0};
		for (int control : ctls) {
			int nextY = cur[0] + dy[control];
			int nextX = cur[1] + dx[control];
			if (outOfRange(nextY, nextX)) {
				continue;
			}
			Pos his = new Pos(cur[0], cur[1], nextY, nextX);
			if (!history.contains(his)) {
				res++;
				history.add(his);
				history.add(new Pos(nextY, nextX, cur[0], cur[1]));
			}
			cur[0] = nextY;
			cur[1] = nextX;
		}

		return res;
	}

	private boolean outOfRange(int y, int x) {
		return y < -5 || y > 5 || x < -5 || x > 5;
	}

	private void makeControls(String dirs) {
		for (char ch : dirs.toCharArray()) {
			switch (ch) {
				case 'D':
					ctls.add(0);
					break;
				case 'R':
					ctls.add(1);
					break;
				case 'U':
					ctls.add(2);
					break;
				case 'L':
					ctls.add(3);
					break;
			}
		}
	}

	static class Pos {
		int sY;
		int sX;
		int eY;
		int eX;

		public Pos(int sY, int sX, int eY, int eX) {
			this.sY = sY;
			this.sX = sX;
			this.eY = eY;
			this.eX = eX;
		}

		public int hashCode() {
			return Objects.hash(sY, sX, eY, eX);
		}

		public boolean equals(Object o) {
			if (o == null || o.getClass() != this.getClass()) {
				return false;
			}
			Pos other = (Pos)o;
			return this.sY == other.sY &&
				this.sX == other.sX &&
				this.eY == other.eY &&
				this.eX == other.eX;
		}
	}
}
