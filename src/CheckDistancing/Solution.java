package CheckDistancing;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static int[] solution(String[][] places) {

        List<Integer> res = new LinkedList<>();

        for (String[] place : places) {
            char[][] arr = new char[7][7];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i == 0 || i == 6 || j == 0 || j == 6) {
                        arr[i][j] = 'X';
                    } else {
                        arr[i][j] = place[i - 1].charAt(j - 1);
                    }
                }
            }

            boolean invalid = false;
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (arr[i][j] == 'P' && isInvalid(arr, j, i, false)) {
                        invalid = true;
                        break;
                    }
                }
            }

            if (invalid) {
                res.add(0);
            } else {
                res.add(1);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean isInvalid(char[][] arr, int x, int y, boolean isEnd) {
        if (isEnd) {
            return arr[y - 1][x] == 'P' || arr[y][x + 1] == 'P' || arr[y + 1][x] == 'P' || arr[y][x - 1] == 'P';
        } else {
            arr[y][x] = 'X';
            //상
            if (arr[y - 1][x] == 'P') {
                return true;
            } else {
                if (arr[y - 1][x] != 'X' && isInvalid(arr, x, y - 1, true)) {
                    return true;
                }
            }
            //우
            if (arr[y][x + 1] == 'P') {
                return true;
            } else {
                if (arr[y][x + 1] != 'X' && isInvalid(arr, x + 1, y, true)) {
                    return true;
                }
            }
            //하
            if (arr[y + 1][x] == 'P') {
                return true;
            } else {
                if (arr[y + 1][x] != 'X' && isInvalid(arr, x, y + 1, true)) {
                    return true;
                }
            }
            //좌
            if (arr[y][x - 1] == 'P') {
                return true;
            } else {
                if (arr[y][x - 1] != 'X' && isInvalid(arr, x - 1, y, true)) {
                    return true;
                }
            }
            arr[y][x] = 'P';
            return false;
        }
    }
}
