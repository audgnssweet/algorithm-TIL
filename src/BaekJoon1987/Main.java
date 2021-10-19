package BaekJoon1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int xMax;
    static int yMax;
    static char[][] arr;

    static boolean[] visit = new boolean[26];
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        yMax = Integer.parseInt(first[0]);
        xMax = Integer.parseInt(first[1]);

        arr = new char[yMax][];
        for (int y = 0; y < yMax; y++) {
            arr[y] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int depth) {
        ans = Math.max(ans, depth);
        int curIdx = arr[y][x] - 'A';
        visit[curIdx] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= xMax || nextY >= yMax || visit[arr[nextY][nextX] - 'A']) {
                continue;
            }

            dfs(nextX, nextY, depth + 1);
        }

        visit[curIdx] = false;
    }
}
