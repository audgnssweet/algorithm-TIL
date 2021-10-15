package BaekJoon1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] info = new int[3];
            for (int idx = 0; idx < info.length; idx++) {
                info[idx] = Integer.parseInt(st.nextToken());
            }

            int[][] arr = new int[info[1] + 2][info[0] + 2];
            while (info[2] > 0) {
                StringTokenizer posT = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(posT.nextToken());
                int y = Integer.parseInt(posT.nextToken());

                arr[y + 1][x + 1] = 1;
                --info[2];
            }

            int ans = 0;
            for (int y = 1; y < arr.length - 1; y++) {
                for (int x = 1; x < arr[y].length - 1; x++) {
                    if (arr[y][x] == 1) {
                        dfs(arr, x, y);
                        ans += 1;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static void dfs(int[][] arr, int x, int y) {
        arr[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (arr[nextY][nextX] == 1) {
                dfs(arr, nextX, nextY);
            }
        }
    }
}
