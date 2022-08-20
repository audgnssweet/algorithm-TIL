package toss;

import java.util.Arrays;

public class Solution2 {

	public int solution(int[] levels) {
		Arrays.sort(levels);
		//배열의 길이가 4보다 작으면, 상위 25%가 존재할 수 없다.
		if (levels.length < 4) {
			return -1;
		}
		//배열의 길이 곱하기 0.25 하고, 실수부는 버림한다.
		int idx = (int)(Math.floor(levels.length * 0.25));
		return levels[levels.length - idx];
	}
}
