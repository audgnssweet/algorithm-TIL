package Ddangddaemokgi;

public class Solution {

    static int[] find(int[] arr) {
        int first = arr[0], firstIdx = 0, second = 0, secondIdx = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                secondIdx = firstIdx;
                first = arr[i];
                firstIdx = i;
            } else {
                if (arr[i] > second) {
                    second = arr[i];
                    secondIdx = i;
                }
            }
        }
        return new int[]{first, firstIdx, second, secondIdx};
    }

    static int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            int[] res = find(land[i - 1]);

            int first = res[0], firstIdx = res[1], second = res[2], secondIdx = res[3];

            for (int j = 0; j < land[i].length; j++) {
                if (j == firstIdx) {
                    land[i][j] += second;
                } else {
                    land[i][j] += first;
                }
            }
        }

        return find(land[land.length - 1])[0];
    }

    public static void main(String[] args) {
        solution(new int[][]{
            {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        });
    }
}
