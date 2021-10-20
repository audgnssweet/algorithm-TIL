package BaekJoon2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int yMax;
    static int xMax;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int count = 0;
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        yMax = Integer.parseInt(info[0]);
        xMax = Integer.parseInt(info[1]);

        StringTokenizer st;
        arr = new int[yMax][xMax];
        for (int y = 0; y < yMax - 1; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xMax - 1; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            melt(new int[yMax][xMax]);

            count = 0;
            boolean[][] visit = new boolean[yMax][xMax];
            for (int y = 1; y < yMax - 1; y++) {
                for (int x = 1; x < xMax - 1; x++) {
                    if (arr[y][x] > 0 && !visit[y][x]) {
                        findCount(x, y, visit);
                        count++;

                        if (count > 1) {
                            break;
                        }
                    }
                }
            }

            if (count != 1) {
                break;
            }

            ans += 1;
        }

        System.out.println(count == 0 ? count : ans);
    }

    private static void findCount(int x, int y, boolean[][] visit) {
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (visit[nextY][nextX] || arr[nextY][nextX] == 0) {
                continue;
            }

            findCount(nextX, nextY, visit);
        }
    }

    private static void melt(int[][] temp) {
        for (int y = 1; y < yMax - 1; y++) {
            for (int x = 1; x < xMax - 1; x++) {

                int meltCount = 0;
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (arr[nextY][nextX] <= 0) {
                        meltCount++;
                    }
                }

                temp[y][x] = meltCount;
            }
        }

        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if (temp[y][x] != 0) {
                    arr[y][x] = Math.max(arr[y][x] - temp[y][x], 0);
                }
            }
        }
    }
}
