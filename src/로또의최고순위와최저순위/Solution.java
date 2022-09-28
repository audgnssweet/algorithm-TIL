package 로또의최고순위와최저순위;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] {}, new int[] {});
	}

	public int[] solution(int[] lottos, int[] win_nums) {
		Set<Integer> wins = new HashSet<>();
		for (int win : win_nums) {
			wins.add(win);
		}

		int zero = 0;
		int dang = 0;
		for (int l : lottos) {
			if (l == 0) {
				zero++;
			} else if (wins.contains(l)) {
				dang++;
			}
		}

		int min = dang <= 1 ? 6 : (7 - dang);
		int max = (dang + zero) <= 1 ? 6 : (7 - (dang + zero));

		return new int[] {max, min};
	}
}
