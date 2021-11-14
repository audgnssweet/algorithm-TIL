package BaekJoon1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = arr[0];
        /* 초기화 끝 */

        for (int i = 1; i < arr.length; i++) {
            /* 자기 자신과, 이전까지의 합 중 최대값을 더한 것 중 더 큰 것으로 갱신 */
            arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
            ans = Math.max(ans, arr[i]);
        }

        System.out.println(ans);
    }
}
