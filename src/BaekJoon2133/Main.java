package BaekJoon2133;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int[] dp = new int[N + 1];
		dp[0] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + getDp(dp, i - 2);
		}

		System.out.println(dp[N]);
		scanner.close();
	}

	private static int getDp(int[] dp, int i) {
		if (i >= 0) {
			return dp[i] * 2 + getDp(dp, i - 2);
		}
		return 0;
	}
}
