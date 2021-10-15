package MultiplyMatrix;

public class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr2[0].length];
        int len = arr2.length;

        for (int y = 0; y < res.length; y++) {
            for (int x = 0; x < res[y].length; x++) {

                int temp = 0;
                for (int i = 0; i < len; i++) {
                    temp += (arr1[y][i] * arr2[i][x]);
                }

                res[y][x] = temp;
            }
        }

        return res;
    }
}
