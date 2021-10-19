package BaekJoon2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        arr = new int[len][len];

        int maxNum = 0;
        for (int y = 0; y < len; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < len; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                maxNum = Math.max(maxNum, arr[y][x]);
            }
        }

        int ans = 0;
        for (int k = maxNum - 1; k >= 0; --k) {
            visit = new boolean[len][len];
            int curCount = 0;
            for (int y = 0; y < len; y++) {
                for (int x = 0; x < len; x++) {
                    if (arr[y][x] > k && !visit[y][x]) {
                        curCount += 1;
                        dfs(x, y, len, k);
                    }
                }
            }
            ans = Math.max(ans, curCount);
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y, int len, int height) {
        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= len || nextY >= len || visit[nextY][nextX]
                || arr[nextY][nextX] <= height) {
                continue;
            }

            dfs(nextX, nextY, len, height);
        }
    }
}
