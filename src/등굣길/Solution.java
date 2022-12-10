package 등굣길;

class Solution {
	public int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[n + 2][m + 2];
		for(int[] p : puddles) {
			map[p[1]][p[0]] = -1;
		}

		map[1][1] = 1;
		for(int y = 1; y < map.length - 1; y++) {
			for(int x = 1; x < map[y].length - 1; x++) {
				if(map[y][x] == -1) {
					continue;
				}

				if(map[y][x + 1] != -1) {
					map[y][x + 1] = (map[y][x] + map[y][x + 1]) % 1_000_000_007;
				}
				if(map[y + 1][x] != -1) {
					map[y + 1][x] = (map[y][x] + map[y + 1][x]) % 1_000_000_007;
				}
			}
		}
		return map[n][m];
	}
}
