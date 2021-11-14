package BaekJoon2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(br.readLine());
        int[] stairs = new int[stairCount + 1];
        int[] dp = new int[stairCount + 1];

        for (int i = 1; i < stairs.length; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if (stairCount >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        for (int i = 3; i < dp.length; i++) {
            //i - 2번째에서 바로 온 것이라면 바로, 직전 계단을 밟을 것이라면 i - 3번까지 가장 큰 값을.
            dp[i] = Math.max(stairs[i - 1] + dp[i - 3], dp[i - 2]) + stairs[i];
        }

        System.out.println(dp[stairCount]);
        br.close();
    }
}
