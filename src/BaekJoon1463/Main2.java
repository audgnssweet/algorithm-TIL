package BaekJoon1463;

import java.util.Scanner;

public class Main2 {

    static Integer[] res = new Integer[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        res[1] = 0;
        System.out.println(recursive(target));
    }

    private static int recursive(int n) {
        if (res[n] != null) {
            return res[n];
        }

        if (n % 6 == 0) {
            res[n] = Math.min(recursive(n / 3), Math.min(recursive(n / 2), recursive(n - 1))) + 1;
        } else if (n % 3 == 0) {
            res[n] = Math.min(recursive(n / 3), recursive(n - 1)) + 1;
        } else if (n % 2 == 0) {
            res[n] = Math.min(recursive(n / 2), recursive(n - 1)) + 1;
        } else {
            res[n] = recursive(n - 1) + 1;
        }
        return res[n];
    }
}
