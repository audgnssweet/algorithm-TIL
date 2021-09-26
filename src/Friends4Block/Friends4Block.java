package Friends4Block;

import java.util.LinkedList;

public class Friends4Block {

    public int solution(int m, int n, String[] board) {
        int res = 0;

        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        LinkedList<int[]> list = new LinkedList<>();

        while (true) {

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] != ' ' && arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i + 1][j]
                        && arr[i][j] == arr[i + 1][j + 1]) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            if (list.size() == 0) {
                break;
            }

            while (!list.isEmpty()) {
                int[] cur = list.pollFirst();
                int y = cur[0], x = cur[1];
                if (arr[y][x] != ' ') {
                    ++res;
                }
                arr[y][x] = ' ';
                if (arr[y][x + 1] != ' ') {
                    ++res;
                }
                arr[y][x + 1] = ' ';
                if (arr[y + 1][x] != ' ') {
                    ++res;
                }
                arr[y + 1][x] = ' ';
                if (arr[y + 1][x + 1] != ' ') {
                    ++res;
                }
                arr[y + 1][x + 1] = ' ';
            }

            for (int col = 0; col < n; col++) {
                int space = m - 1;
                while (space >= 0 && arr[space][col] != ' ') {
                    --space;
                }

                int block = space - 1;

                while (block >= 0) {
                    if (arr[block][col] != ' ') {
                        char tmp = arr[block][col];
                        arr[block][col] = ' ';
                        arr[space][col] = tmp;
                        --space;
                    }
                    --block;
                }
            }
        }

        return res;
    }

}