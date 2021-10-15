package BaekJoon2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        init();

        int ans = 0;
        for (int y = 1; y < arr.length - 1; y++) {
            for (int x = 1; x < arr[y].length - 1; x++) {
                if (arr[y][x] == 1) {
                    pq.offer(bfs(x, y));
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static int bfs(int x, int y) {
        arr[y][x] = 0;
        int[] start = {x, y};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        int count = 0;
        while (!q.isEmpty()) {
            count += 1;
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (arr[nextY][nextX] == 1) {
                    arr[nextY][nextX] = 0;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
        return count;
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2][N + 2];
        for (int y = 1; y < arr.length - 1; y++) {
            String s = br.readLine();
            for (int x = 1; x < arr[y].length - 1; x++) {
                arr[y][x] = s.charAt(x - 1) - '0';
            }
        }
    }
}
