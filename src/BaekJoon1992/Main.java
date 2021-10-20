package BaekJoon1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder ans = new StringBuilder();
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        arr = new int[len][len];
        for (int y = 0; y < len; y++) {
            String curLine = br.readLine();
            for (int x = 0; x < len; x++) {
                arr[y][x] = curLine.charAt(x) - '0';
            }
        }

        divideAndConquer(0, 0, len);
        System.out.println(ans);
    }

    private static void divideAndConquer(int startX, int startY, int len) {
        if (canCompress(startX, startY, len)) {
            ans.append(arr[startY][startX]);
        } else {
            int divLen = len / 2;
            ans.append('(');
            divideAndConquer(startX, startY, divLen);
            divideAndConquer(startX + divLen, startY, divLen);
            divideAndConquer(startX, startY + divLen, divLen);
            divideAndConquer(startX + divLen, startY + divLen, divLen);
            ans.append(')');
        }
    }

    private static boolean canCompress(int startX, int startY, int len) {
        int target = arr[startY][startX];
        for (int y = startY; y < startY + len; y++) {
            for (int x = startX; x < startX + len; x++) {
                if (arr[y][x] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}
