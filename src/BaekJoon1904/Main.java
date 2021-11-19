package BaekJoon1904;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] res = new int[1000001];

        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % 15746;
        }

        System.out.println(res[n]);
    }
}
