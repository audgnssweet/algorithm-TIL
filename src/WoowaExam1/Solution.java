package WoowaExam1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int[] solution(int[][] v) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for (int[] pos : v) {
            if (xList.contains(pos[0])) {
                xList.remove(Integer.valueOf(pos[0]));
            } else {
                xList.add(pos[0]);
            }

            if (yList.contains(pos[1])) {
                yList.remove(Integer.valueOf(pos[1]));
            } else {
                yList.add(pos[1]);
            }
        }

        return new int[]{xList.get(0), yList.get(0)};
    }

    public static void main(String[] args) {
        solution(new int[][]{
            {1, 4},
            {3, 4},
            {3, 10}
        });
    }
}
