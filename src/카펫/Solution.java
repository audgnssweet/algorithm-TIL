package 카펫;

class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = {};

		//brown = 가로 * 2 + (세로 - 2) * 2
		//yellow = 가로 * 세로 - brown

		for (int width = 3; ; width++) {
			for (int height = 1; height <= width; height++) {
				int b = width * 2 + (height - 2) * 2;
				int y = width * height - b;

				if (b == brown && y == yellow) {
					return new int[] {width, height};
				}
			}
		}
	}
}
