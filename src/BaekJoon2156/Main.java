package BaekJoon2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 3];
        for (int i = 3; i < n + 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int[] dp = new int[n + 3];
        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
        br.close();
    }
}
