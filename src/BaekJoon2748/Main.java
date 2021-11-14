package BaekJoon2748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] piv = new long[n + 1];
        piv[0] = 0;
        piv[1] = 1;

        for (int i = 2; i <= n; i++) {
            piv[i] = piv[i - 1] + piv[i - 2];
        }
        System.out.println(piv[n]);
    }
}
