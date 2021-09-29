package SpinMatrixEdge;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> res = new LinkedList<>();

        int[][] arr = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = cnt++;
            }
        }

        //each query마다
        for (int[] query : queries) {
            int y1 = query[0] - 1;
            int x1 = query[1] - 1;
            int y2 = query[2] - 1;
            int x2 = query[3] - 1;

            int curMin = Integer.MAX_VALUE;
            int tmp = arr[y1][x1];
            //위로땡
            for (int i = y1; i < y2; i++) {
                arr[i][x1] = arr[i + 1][x1];
                curMin = Math.min(curMin, arr[i][x1]);
            }
            //왼쪽땡
            for (int i = x1; i < x2; i++) {
                arr[y2][i] = arr[y2][i + 1];
                curMin = Math.min(curMin, arr[y2][i]);
            }
            //아래땡
            for (int i = y2; i > y1; --i) {
                arr[i][x2] = arr[i - 1][x2];
                curMin = Math.min(curMin, arr[i][x2]);
            }
            //오른땡
            for (int i = x2; i > x1; --i) {
                arr[y1][i] = arr[y1][i - 1];
                curMin = Math.min(curMin, arr[y1][i]);
            }

            arr[y1][x1 + 1] = tmp;
            curMin = Math.min(curMin, tmp);

            res.add(curMin);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
