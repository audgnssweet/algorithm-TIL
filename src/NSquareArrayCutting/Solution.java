package NSquareArrayCutting;

import java.util.Arrays;

public class Solution {

    public static int[] solution(int n, long left, long right) {

        int startY = (int) (left / n);
        int startX = (int) (left % n);
        int endY = (int) (right / n);
        int endX = (int) (right % n);

        int[] res = new int[n * (endY - startY + 1)];

        int idx = 0;
        for (int y = startY; y <= endY; y++) {
            int tempY = y + 1;
            for (int x = 0; x < n; ++x) {
                if (x <= y) {
                    res[idx++] = tempY;
                } else {
                    res[idx++] = ++tempY;
                }
            }
        }

        return Arrays.copyOfRange(res, startX, res.length - (n - 1 - endX));
    }

    public static void main(String[] args) {
        solution(3,2,5);
    }
}
