package BaekJoon7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int xMax;
    static int yMax;
    static int[][] arr;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static Queue<int[]> q = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        init();

        int ans = bfs();

        System.out.println(count == 0 ? ans : -1);
    }

    static int bfs() {
        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count -= 1;
            ans = Math.max(ans, cur[2]);
            if (count == 0) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (arr[nextY][nextX] == 0 && nextX >= 1 && nextX <= xMax && nextY >= 1 && nextY <= yMax) {
                    arr[nextY][nextX] = 1;
                    q.offer(new int[]{nextX, nextY, cur[2] + 1});
                }
            }
        }

        return ans;
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        xMax = Integer.parseInt(st.nextToken());
        yMax = Integer.parseInt(st.nextToken());

        arr = new int[yMax + 2][xMax + 2];
        for (int y = 1; y < arr.length - 1; y++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int x = 1; x < arr[y].length - 1; x++) {
                int cur = Integer.parseInt(line.nextToken());
                arr[y][x] = cur;

                if (cur == 1) {
                    q.offer(new int[]{x, y, 0});
                }
                if (cur != -1) {
                    count += 1;
                }
            }
        }
    }
}
