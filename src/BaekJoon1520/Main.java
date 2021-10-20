package BaekJoon1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int xMax;
    static int yMax;
    static int[][] arr, res;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");

        yMax = Integer.parseInt(first[0]);
        xMax = Integer.parseInt(first[1]);
        arr = new int[yMax][xMax];
        res = new int[yMax][xMax];

        for (int y = 0; y < yMax; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xMax; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                res[y][x] = -1;
            }
        }

        dfs(0, 0);
        System.out.println(res[0][0]);
        br.close();
    }

    private static int dfs(int x, int y) {
        if (x == xMax - 1 && y == yMax - 1) {
            return 1;
        }

        if (res[y][x] != -1) {
            return res[y][x];
        }

        res[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= xMax || nextY >= yMax || arr[nextY][nextX] >= arr[y][x]) {
                continue;
            }

            res[y][x] += dfs(nextX, nextY);
        }

        return res[y][x];
    }
}
