package StarAtVertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static String[] solution(int[][] line) {
        long xMin = Long.MAX_VALUE, xMax = Long.MIN_VALUE, yMin = Long.MAX_VALUE, yMax = Long.MIN_VALUE;
        List<long[]> ans = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {

                long a = line[i][0];
                long b = line[i][1];
                long c = line[j][0];
                long d = line[j][1];
                long e = line[i][2];
                long f = line[j][2];

                long res = (a * d) - (b * c);
                long x = (b * f) - (e * d);
                long y = (e * c) - (a * f);
                if (res != 0 && x % res == 0 && y % res == 0) {
                    x /= res;
                    y /= res;
                    xMin = (int) Math.min(xMin, x);
                    xMax = (int) Math.max(xMax, x);
                    yMin = (int) Math.min(yMin, y);
                    yMax = (int) Math.max(yMax, y);

                    ans.add(new long[]{x, y});
                }
            }
        }

        int xLen = (int) (xMax - xMin + 1);
        int yLen = (int) (yMax - yMin + 1);

        char[][] arr = new char[yLen][xLen];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], '.');
        }

        for (long[] a : ans) {
            int x = (int) Math.abs(xMin - a[0]);
            int y = (int) (yMax - a[1]);

            arr[y][x] = '*';
        }

        String[] temp = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = new String(arr[i]);
        }

        return temp;
    }
}
