package BaekJoon11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static Integer[] dp;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrSize = Integer.parseInt(br.readLine());
        arr = new int[arrSize];
        dp = new Integer[arrSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dp.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            findMax(i);
        }
        System.out.println(max);
    }

    private static int findMax(int index) {
        if (dp[index] == null) {
            //한번 탐색 했는지 아닌지를 null의 여부로 판단
            dp[index] = 1;

            for (int i = index - 1; i >= 0; --i) {
                if (arr[index] > arr[i]) {
                    //현재 index보다 작은 index들 중, 더 작은 값을 가진 것만 탐색
                    dp[index] = Math.max(dp[index], findMax(i) + 1); // +1 해주는 것은 현재노드
                }
            }
        }
        max = Math.max(max, dp[index]);
        return dp[index];
    }
}
