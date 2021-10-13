package VisitedLength;

import java.util.HashSet;
import java.util.Objects;

public class Solution {

    static HashSet<Edge> set = new HashSet<>();
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    public static int solution(String dirs) {
        dirs = transform(dirs);
        int x = 0, y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int cur = dirs.charAt(i) - '0';

            if (Math.abs(x + dx[cur]) > 5 || Math.abs(y + dy[cur]) > 5) {
                continue;
            }
            set.add(new Edge(x, y, x + dx[cur], y + dy[cur]));
            set.add(new Edge(x + dx[cur], y + dy[cur], x, y));

            x += dx[cur];
            y += dy[cur];
        }

        return set.size() / 2;
    }

    private static String transform(String dirs) {
        return dirs
            .replaceAll("U", "0")
            .replaceAll("R", "1")
            .replaceAll("D", "2")
            .replaceAll("L", "3");
    }

    static class Edge {

        int startX;
        int startY;
        int endX;
        int endY;

        public Edge(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !o.getClass().equals(this.getClass())) {
                return false;
            }
            Edge edge = (Edge) o;
            return startX == edge.startX && startY == edge.startY && endX == edge.endX && endY == edge.endY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startX, startY, endX, endY);
        }
    }
}
