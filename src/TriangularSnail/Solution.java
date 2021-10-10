package TriangularSnail;

public class Solution {

    public static int[] solution(int n) {
        int end = n * (n + 1) / 2;
        int[][] temp = new int[n][];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new int[i + 1];
        }

        int start = 1;
        int x = 0, y = 0;
        while (start <= end) {
            //아래
            while (y < temp.length && temp[y][x] == 0) {
                temp[y++][x] = start++;
            }
            y -= 1;
            x += 1;
            //오른
            while (x < temp[y].length && temp[y][x] == 0) {
                temp[y][x++] = start++;
            }
            x -= 2;
            y -= 1;
            //대각
            while (y >= 0 && x >= 0 && temp[y][x] == 0) {
                temp[y--][x--] = start++;
            }
            y += 2;
            x += 1;
        }

        int[] res = new int[end];
        int idx = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                res[idx++] = temp[i][j];
            }
        }

        return res;
    }
}
