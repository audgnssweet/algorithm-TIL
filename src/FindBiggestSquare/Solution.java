package FindBiggestSquare;

public class Solution {

    static int[] dx = new int[]{-1, -1, 0};
    static int[] dy = new int[]{0, -1, -1};

    public static int solution(int[][] board) {
        int res = 0;

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if ((y == 0 || x == 0) && board[y][x] == 1) {
                    res = res <= 0 ? 1 : res;
                } else if (board[y][x] != 0) {
                    int min = Integer.MAX_VALUE;
                    for (int i = 0; i < dx.length; i++) {
                        int curX = x + dx[i];
                        int curY = y + dy[i];
                        min = Math.min(min, board[curY][curX]);
                    }
                    board[y][x] = min + 1;
                    res = Math.max(res, board[y][x]);
                }
            }
        }

        return res * res;
    }
}
