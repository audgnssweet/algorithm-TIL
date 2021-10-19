package BaekJoon4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] first = br.readLine().split(" ");
            int xMax = Integer.parseInt(first[0]);
            int yMax = Integer.parseInt(first[1]);

            if (xMax == 0 && yMax == 0) {
                break;
            }

            int[][] arr = new int[yMax][xMax];
            for (int y = 0; y < yMax; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < xMax; x++) {
                    arr[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    if (arr[y][x] == 1) {
                        dfs(arr, x, y, xMax, yMax);
                        count += 1;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int[][] arr, int x, int y, int xMax, int yMax) {
        arr[y][x] = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= xMax || nextY >= yMax) {
                continue;
            }

            if (arr[nextY][nextX] == 1) {
                dfs(arr, nextX, nextY, xMax, yMax);
            }
        }
    }
}
