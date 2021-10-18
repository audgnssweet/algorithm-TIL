package BaekJoon2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Loc {

        int x;
        int y;
        int depth;
        boolean wall;

        public Loc(int x, int y, int depth, boolean wall) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.wall = wall;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int yMax = Integer.parseInt(st.nextToken());
        int xMax = Integer.parseInt(st.nextToken());

        int[][] arr = new int[yMax][xMax];
        boolean[][][] visit = new boolean[2][yMax][xMax];

        for (int y = 0; y < yMax; y++) {
            String nextLine = br.readLine();
            for (int x = 0; x < xMax; x++) {
                arr[y][x] = nextLine.charAt(x) - '0';
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(0, 0, 1, false));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            if (cur.x == xMax - 1 && cur.y == yMax - 1) {
                System.out.println(cur.depth);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= xMax || nextY >= yMax) {
                    continue;
                }

                if (arr[nextY][nextX] == 0) {
                    //다음이 벽이 아닌경우
                    if (!cur.wall && !visit[0][nextY][nextX]) {
                        //부순 벽이 없으면서 부순 벽이 없는쪽이 방문이 안된 경우
                        q.offer(new Loc(nextX, nextY, cur.depth + 1, cur.wall));
                        visit[0][nextY][nextX] = true;
                    } else if (cur.wall && !visit[1][nextY][nextX]) {
                        //부순 벽이 있는데 부순 벽이 있는쪽이 방문이 안된경우
                        q.offer(new Loc(nextX, nextY, cur.depth + 1, cur.wall));
                        visit[1][nextY][nextX] = true;
                    }
                } else {
                    //다음이 벽인경우
                    if (!cur.wall) {
                        //다음이 벽이면서 누가 뚫은적이 없는 경우
                        q.offer(new Loc(nextX, nextY, cur.depth + 1, true));
                        visit[1][nextY][nextX] = true;
                    }
                }
            }

        }
        System.out.println(-1);
    }
}
