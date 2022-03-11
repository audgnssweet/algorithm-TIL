package BaekJoon12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int WEIGHT = 0;
	private static int VALUE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[][] things = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			String[] WV = br.readLine().split(" ");
			things[i][WEIGHT] = Integer.parseInt(WV[WEIGHT]);
			things[i][VALUE] = Integer.parseInt(WV[VALUE]);
		}

		int[][] dp = new int[N + 1][K + 1];
		for (int maxWeight = 1; maxWeight <= K; maxWeight++) {
			for (int curThing = 1; curThing <= N; curThing++) {
				//자기 자신을 넣을 수 있다면, 자기 자신을 뺀 무게 + 자기 자신 전까지의 최대값과 이전 물건까지의 최대값 비교
				//아니라면 그냥 이전값을 넣기
				int curWeight = things[curThing][WEIGHT];
				int thingBefore = curThing - 1;
				if (curWeight > maxWeight) {
					dp[curThing][maxWeight] = dp[thingBefore][maxWeight];
				} else {
					int remainWeight = maxWeight - curWeight;
					dp[curThing][maxWeight] = Math.max(things[curThing][VALUE] + dp[thingBefore][remainWeight],
						dp[thingBefore][maxWeight]);
				}
			}
		}
		System.out.println(dp[N][K]);
		br.close();
	}
}
