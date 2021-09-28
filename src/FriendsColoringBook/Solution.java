package FriendsColoringBook;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] visited = new int[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                visited[i][j] = picture[i][j];
            }
        }

        Deque<Point> deque = new LinkedList<>();
        int cur = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (visited[i][j] != 0) {
                    cur = visited[i][j];
                    deque.addLast(new Point(j, i));

                    numberOfArea += 1;
                    int curArea = 0;
                    while (!deque.isEmpty()) {
                        Point point = deque.pollFirst();
                        int x = point.x;
                        int y = point.y;

                        if (visited[y][x] == 0) {
                            continue;
                        }
                        visited[y][x] = 0;
                        curArea += 1;
                        //상
                        if (y > 0 && visited[y - 1][x] == cur) {
                            deque.addLast(new Point(x, y - 1));
                        }
                        //우
                        if (x < n - 1 && visited[y][x + 1] == cur) {
                            deque.addLast(new Point(x + 1, y));
                        }
                        //하
                        if (y < m - 1 && visited[y + 1][x] == cur) {
                            deque.addLast(new Point(x, y + 1));
                        }
                        //좌
                        if (x > 0 && visited[y][x - 1] == cur) {
                            deque.addLast(new Point(x - 1, y));
                        }
                    }

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, curArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

}
