package ShortestGameMap;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        int targetY = maps.length - 1;
        int targetX = maps[0].length - 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0], curX = cur[1], curDepth = cur[2];

            if (curX == targetX && curY == targetY) {
                return curDepth;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextY == maps.length || nextY == -1 || nextX == maps[0].length || nextX == -1
                    || maps[nextY][nextX] != 1) {
                    continue;
                }

                q.add(new int[]{nextY, nextX, curDepth + 1});
                maps[nextY][nextX] = 0;
            }
        }

        return -1;
    }

}
