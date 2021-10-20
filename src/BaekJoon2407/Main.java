package BaekJoon2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int r = Integer.parseInt(first[1]);

        BigInteger[][] arr = new BigInteger[n + 1][n + 1];
        for (int curN = 1; curN <= n; curN++) {
            for (int curR = 0; curR <= curN; curR++) {
                if (curR == 0 || curR == curN) {
                    arr[curN][curR] = new BigInteger("1");
                } else {
                    arr[curN][curR] = arr[curN - 1][curR - 1].add(arr[curN - 1][curR]);
                }
            }
        }

        System.out.println(arr[n][r]);
    }
}
