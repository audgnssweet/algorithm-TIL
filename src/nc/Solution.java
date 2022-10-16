package nc;

public class Solution {
	public static void main(String[] args) {
		int[][] graph = new int[13][13];
		graph[1][2] = 1;
		graph[1][3] = 1;

		graph[2][1] = 1;
		graph[2][3] = 1;

		graph[3][1] = 1;
		graph[3][2] = 1;
		graph[3][4] = 1;
		graph[3][5] = 1;

		graph[4][3] = 1;
		graph[4][5] = 1;

		graph[5][3] = 1;
		graph[5][4] = 1;
		graph[5][6] = 1;
		graph[5][7] = 1;

		graph[6][5] = 1;
		graph[6][7] = 1;

		graph[7][5] = 1;
		graph[7][6] = 1;
		graph[7][8] = 1;

		graph[8][7] = 1;
		graph[8][9] = 1;
		graph[8][10] = 1;

		graph[9][8] = 1;
		graph[9][10] = 1;

		graph[10][8] = 1;
		graph[10][9] = 1;
		graph[10][11] = 1;
		graph[10][12] = 1;

		graph[11][10] = 1;
		graph[11][12] = 1;

		graph[12][11] = 1;
		graph[12][10] = 1;
	}
}
