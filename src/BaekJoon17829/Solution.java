package BaekJoon17829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        arr = new int[size][size];
        for (int y = 0; y < size; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < size; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(divideConquer(size, size - 1, size - 1));
    }

    static int divideConquer(int size, int xEnd, int yEnd) {
        if (size == 1) {
            return arr[yEnd][xEnd];
        } else {
            int[] temp = new int[]{
                divideConquer(size / 2, xEnd - (size / 2), yEnd - (size / 2)),
                divideConquer(size / 2, xEnd, yEnd - (size / 2)),
                divideConquer(size / 2, xEnd - (size / 2), yEnd),
                divideConquer(size / 2, xEnd, yEnd)
            };
            Arrays.sort(temp);
            return temp[2];
        }
    }
}
