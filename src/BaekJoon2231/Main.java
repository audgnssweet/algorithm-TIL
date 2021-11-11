package BaekJoon2231;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        boolean isFound = false;
        for (int i = 1; i < N; i++) {
            int temp = i;
            int M = temp;
            while (temp > 0) {
                M += temp % 10;
                temp /= 10;
            }

            if (M == N) {
                System.out.println(i);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println(0);
        }
    }
}
