package wooteco.five;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

    static class Edge {

        int x;
        int y;
        char dir;

        public Edge(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Edge edge = (Edge) o;
            if (x != edge.x || y != edge.y || dir != edge.dir) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(x, y, dir);
        }
    }

    public static int[][] solution(int rows, int columns) {
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        char[] dirs = {'d', 'r'};

        int num = 1;
        int[][] arr = new int[rows][columns];
        int zeroCount = rows * columns;
        int curY = 0, curX = 0;

        Set<Edge> set = new HashSet<>();

        while (zeroCount > 0) {
            if (arr[curY][curX] == 0) {
                zeroCount--;
            }

            char nextDir = (dirs[num % 2]);
            if (set.contains(new Edge(curX, curY, nextDir))) {
                break;
            }

            arr[curY][curX] = num;
            set.add(new Edge(curX, curY, nextDir));

            curY = (curY + dy[num % 2]) % rows;
            curX = (curX + dx[num % 2]) % columns;

            num++;
        }

        return arr;
    }

    public static void main(String[] args) {
        solution(2, 2);
    }
}
