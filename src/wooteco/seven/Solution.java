package wooteco.seven;

public class Solution {

    public static String[] solution(String[] grid, boolean clockwise) {
        StringBuilder[] ans = new StringBuilder[grid.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new StringBuilder();
        }

        if (clockwise) {
            int[] dx = {-1, -1};
            int[] dy = {0, -1};

            for (int i = 0; i < ans.length; i++) {

                int curY = grid.length - 1;
                int curX = 2 * i;

                int k = 0;
                while (curX >= 0) {
                    ans[i].append(grid[curY].charAt(curX));
                    curX += dx[k];
                    curY += dy[k];
                    k = (k + 1) % 2;
                }
            }
        } else {
            int[] dx = {1, -1};
            int[] dy = {1, 0};

            for (int i = 0; i < ans.length; i++) {

                int curY = grid.length - 1 - i;
                int curX = curY * 2;

                int k = 0;
                while (curY <= grid.length - 1) {
                    ans[i].append(grid[curY].charAt(curX));
                    curX += dx[k];
                    curY += dy[k];
                    k = (k + 1) % 2;
                }
            }
        }

        String[] res = new String[ans.length];
        for (int i = 0; i < ans.length; i++) {
            res[i] = new String(ans[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        solution(new String[]{
            "1", "234", "56789"
        }, false);
//        solution(new String[]{
//            "A","MAN","DRINK","WATER11"
//        }, false);
    }
}
