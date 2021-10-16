package MazeExploration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int xMax;
    static int yMax;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        init();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 1});
        arr[1][1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == xMax && cur[1] == yMax) {
                System.out.println(cur[2]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (arr[nextY][nextX] == 1) {
                    arr[nextY][nextX] = 0;
                    q.offer(new int[]{nextX, nextY, cur[2] + 1});
                }
            }
        }
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        yMax = Integer.parseInt(st.nextToken());
        xMax = Integer.parseInt(st.nextToken());

        arr = new int[yMax + 2][xMax + 2];
        for (int y = 1; y <= yMax; y++) {
            String line = br.readLine();
            for (int x = 1; x <= xMax; x++) {
                arr[y][x] = line.charAt(x - 1) - '0';
            }
        }
    }
}
