package QuadCompressionAndCount;

public class Solution {

    public static int[] solution(int[][] arr) {
        int[] nums = new int[2];
        boolean[][] res = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    nums[0] += 1;
                } else {
                    nums[1] += 1;
                }
                res[i][j] = true;
            }
        }

        int n = 0;
        int temp = arr.length;
        while (temp > 1) {
            temp /= 2;
            n += 1;
        }

        for (int i = 1; i <= n; i++) {
            int start = (int) Math.pow(2, i);
            int delta = start / 2;

            for (int y = start - 1; y < arr.length; y += start) {
                for (int x = start - 1; x < arr[y].length; x += start) {
                    if (res[y][x] && res[y - delta][x] && res[y][x - delta] && res[y - delta][x - delta] &&
                        arr[y][x] == arr[y - delta][x] && arr[y][x] == arr[y][x - delta] && arr[y][x] == arr[y - delta][x - delta]) {
                        res[y][x] = true;
                        if (arr[y][x] == 1) {
                            nums[1] -= 3;
                        } else {
                            nums[0] -= 3;
                        }
                    } else {
                        res[y][x] = false;
                    }
                }
            }
        }

        return nums;
    }
}
