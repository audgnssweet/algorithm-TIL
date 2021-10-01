package PathOfLightCycle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Solution {

    static Set<Path> whole = new HashSet<>();
    static char[] dir = new char[]{'N', 'E', 'S', 'W'};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    static char[][] arr;

    public static int[] solution(String[] grid) {
        arr = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                arr[i][j] = grid[i].charAt(j);
            }
        }

        List<Integer> res = new ArrayList<>();
        //반복문으로 4번 체크
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < dir.length; k++) {

                    Path path = new Path(j, i, k);
                    int count = 0;
                    while (!whole.contains(path)) {
                        whole.add(path);
                        count += 1;

                        int nextX = getNextXPos(path.xStart + dx[path.direction]);
                        int nextY = getNextYPos(path.yStart + dy[path.direction]);
                        int nextDir = getDirection(path.direction, arr[nextY][nextX]);

                        path = new Path(nextX, nextY, nextDir);
                    }

                    if (count != 0) {
                        res.add(count);
                    }
                }
            }
        }
        res.sort((o1, o2) -> o1 - o2);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    static int getNextYPos(int cur) {
        if (cur < 0) {
            return arr.length - 1;
        } else if (cur >= arr.length) {
            return 0;
        } else {
            return cur;
        }
    }

    static int getNextXPos(int cur) {
        if (cur < 0) {
            return arr[0].length - 1;
        } else if (cur >= arr[0].length) {
            return 0;
        } else {
            return cur;
        }
    }

    static int getDirection(int cur, char oper) {
        switch (oper) {
            case 'S':
                return cur;
            case 'R':
                return cur == 3 ? 0 : cur + 1;
            default:
                return cur == 0 ? 3 : cur - 1;
        }
    }

    static class Path {

        int xStart;
        int yStart;
        int direction;

        Path(int xStart, int yStart, int direction) {
            this.xStart = xStart;
            this.yStart = yStart;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Path path = (Path) o;

            return (xStart == path.xStart) && (yStart == path.yStart) && (direction == path.direction);
        }

        @Override
        public int hashCode() {
            return Objects.hash(xStart, yStart, direction);
        }
    }

}
