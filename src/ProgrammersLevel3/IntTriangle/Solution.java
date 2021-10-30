package ProgrammersLevel3.IntTriangle;

import java.util.Arrays;

public class Solution {

    public static int solution(int[][] triangle) {
        for (int line = 1; line < triangle.length; line++) {
            triangle[line][0] += triangle[line - 1][0];
            triangle[line][triangle[line].length - 1] += triangle[line - 1][triangle[line].length - 2];
            for (int idx = 1; idx < triangle[line].length - 1; idx++) {
                triangle[line][idx] = Math.max(triangle[line][idx] + triangle[line - 1][idx - 1], triangle[line][idx] + triangle[line - 1][idx]);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}
