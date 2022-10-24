package 치킨배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static int target;

	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		target = Integer.parseInt(NM[1]);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur == 1) {
					houses.add(new int[] {i, j});
				} else if (cur == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}

		dfs(0, 0, new boolean[chickens.size()]);

		System.out.println(res);

		br.close();
	}

	static void dfs(int depth, int choose, boolean[] chosen) {
		if (choose == target) {
			int min = 0;
			for (int[] house : houses) {
				int curMin = Integer.MAX_VALUE;
				for (int i = 0; i < chosen.length; i++) {
					if (chosen[i]) {
						int[] chicken = chickens.get(i);
						int len = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
						curMin = Math.min(curMin, len);
					}
				}
				min += curMin;
			}
			res = Math.min(res, min);
		} else {
			if (depth < chickens.size()) {
				chosen[depth] = true;
				dfs(depth + 1, choose + 1, chosen);
				chosen[depth] = false;
				dfs(depth + 1, choose, chosen);
			}
		}
	}
}
