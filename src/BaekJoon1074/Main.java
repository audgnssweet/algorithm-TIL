package BaekJoon1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;

    static int targetX;
    static int targetY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);

        divideAndConquer(len);
    }

    private static void divideAndConquer(int len) {
        if (len == 1) {
            System.out.println(ans);
        } else {
            int nextLen = len / 2;
            int multiply = 0;
            if (targetX >= nextLen && targetY < nextLen) {
                multiply = 1;
            } else if (targetX < nextLen && targetY >= nextLen) {
                multiply = 2;
            } else if (targetX >= nextLen && targetY >= nextLen) {
                multiply = 3;
            }
            targetX = targetX - nextLen >= 0 ? targetX - nextLen : targetX;
            targetY = targetY - nextLen >= 0 ? targetY - nextLen : targetY;

            ans += (nextLen * nextLen * multiply);
            divideAndConquer(nextLen);
        }
    }
}
