package BaekJoon11726;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] res = new int[1001];

        res[0] = res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % 10007;
        }

        System.out.println(res[target]);
    }
}
