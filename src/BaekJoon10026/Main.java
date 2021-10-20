package BaekJoon10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][][] arr;
    static int len;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());

        arr = new char[2][len][];
        for (int y = 0; y < len; y++) {
            String nextLine = br.readLine();
            arr[0][y] = nextLine.toCharArray();
            arr[1][y] = nextLine.replaceAll("G", "R").toCharArray();
        }

        for (int i = 0; i < 2; i++) {
            int ans = 0;
            for (int y = 0; y < len; y++) {
                for (int x = 0; x < len; x++) {
                    if (arr[i][y][x] != ' ') {
                        ans += 1;
                        dfs(i, x, y);
                    }
                }
            }
            System.out.print(ans + " ");
        }
    }

    static void dfs(int layer, int x, int y) {
        char cur = arr[layer][y][x];
        arr[layer][y][x] = ' ';

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= len || nextY >= len || arr[layer][nextY][nextX] == ' ' || arr[layer][nextY][nextX] != cur) {
                continue;
            }

            dfs(layer, nextX, nextY);
        }
    }
}
