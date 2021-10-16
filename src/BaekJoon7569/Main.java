package BaekJoon7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int xMax;
    static int yMax;
    static int zMax;
    static int[][][] arr;

    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

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
            ans = Math.max(ans, cur[3]);
            if (count == 0) {
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                int nextZ = cur[2] + dz[i];

                if (nextX >= 0 && nextX < xMax && nextY >= 0 && nextY < yMax && nextZ >= 0 && nextZ < zMax && arr[nextZ][nextY][nextX] == 0) {
                    arr[nextZ][nextY][nextX] = 1;
                    q.offer(new int[]{nextX, nextY, nextZ, cur[3] + 1});
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
        zMax = Integer.parseInt(st.nextToken());

        arr = new int[zMax][yMax][xMax];
        for (int z = 0; z < arr.length; z++) {
            for (int y = 0; y < arr[z].length; y++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                for (int x = 0; x < arr[z][y].length; x++) {
                    int cur = Integer.parseInt(line.nextToken());
                    arr[z][y][x] = cur;

                    if (cur == 1) {
                        q.offer(new int[]{x, y, z, 0});
                    }
                    if (cur != -1) {
                        count += 1;
                    }
                }
            }
        }
    }
}
