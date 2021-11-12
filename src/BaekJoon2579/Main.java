package BaekJoon2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(br.readLine());
        int[] stairs = new int[stairCount + 1];
        int[][] res = new int[2][stairCount + 1];

        for (int i = 1; i <= stairCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        /* 점화식 -> res[0][i] = res[1][i - 1] + stairs[i], res[1][i] = Math.max(res[0][i - 2], res[1][i - 2]) + stairs[i] */
        res[0][1] = res[1][1] = stairs[1];

        for (int i = 2; i < stairs.length; i++) {
            /* 전 계단에서 온 것 -> 전전 계단을 밟지 않은 것 */
            res[0][i] = res[1][i - 1] + stairs[i];
            /* 전전 계단에서 온 것 -> 그거랑 상관 없이 젤 큰거 */
            res[1][i] = Math.max(res[0][i - 2], res[1][i - 2]) + stairs[i];
        }
        System.out.println(Math.max(res[0][stairCount], res[1][stairCount]));

        br.close();
    }
}
