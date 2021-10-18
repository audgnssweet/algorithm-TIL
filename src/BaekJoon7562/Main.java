package BaekJoon7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            int len = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[len][len];

            StringTokenizer start = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(start.nextToken());
            int startY = Integer.parseInt(start.nextToken());

            StringTokenizer end = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(end.nextToken());
            int endY = Integer.parseInt(end.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{startX, startY, 0});
            visit[startY][startX] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                if (cur[0] == endX && cur[1] == endY) {
                    System.out.println(cur[2]);
                    break;
                }

                for (int k = 0; k < 8; k++) {
                    int nextX = cur[0] + dx[k];
                    int nextY = cur[1] + dy[k];

                    if (nextX < 0 || nextY < 0 || nextX >= len || nextY >= len || visit[nextY][nextX]) {
                        continue;
                    }

                    q.offer(new int[]{nextX, nextY, cur[2] + 1});
                    visit[nextY][nextX] = true;
                }
            }
        }
    }
}
