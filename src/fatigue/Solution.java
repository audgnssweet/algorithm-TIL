package fatigue;

public class Solution {

	static int[][] dungeon;
	static boolean[] visited;

	static int targetLength;
	static int[][] temp;

	static int point;
	static int res = 0;

	public int solution(int k, int[][] dungeons) {
		dungeon = dungeons;
		visited = new boolean[dungeons.length];

		targetLength = dungeons.length;
		temp = new int[dungeons.length][];

		point = k;

		find(0);

		return res;
	}

	private void find(int depth) {
		if (depth == targetLength) {
			checkMaxDungeonCnt();
		} else {
			for (int i = 0; i < dungeon.length; i++) {
				visited[i] = true;
				temp[depth] = dungeon[i];
				find(depth + 1);
				visited[i] = false;
			}
		}
	}

	private void checkMaxDungeonCnt() {
		int remainPoint = point;

		int cnt = 0;
		while (cnt < temp.length) {
			int[] dungeon = temp[cnt];
			int needPoint = dungeon[0];
			int usePoint = dungeon[1];

			if (remainPoint < needPoint) {
				break;
			}
			remainPoint -= usePoint;
			cnt++;
		}

		res = Math.max(res, cnt);
	}
}
