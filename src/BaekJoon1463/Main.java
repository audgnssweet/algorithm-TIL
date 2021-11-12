package BaekJoon1463;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        int[] res = new int[1000001];
        res[target] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(target);

        while (!q.isEmpty() && res[1] == 0) {
            int cur = q.poll();

            if ((cur % 3 == 0) && (cur / 3 > 0) && res[cur / 3] == 0) {
                res[cur / 3] = res[cur] + 1;
                q.offer(cur / 3);
            }
            if ((cur % 2 == 0) && (cur / 2 > 0) && res[cur / 2] == 0) {
                res[cur / 2] = res[cur] + 1;
                q.offer(cur / 2);
            }
            if (cur - 1 > 0 && res[cur - 1] == 0) {
                res[cur - 1] = res[cur] + 1;
                q.offer(cur - 1);
            }
        }

        System.out.println(res[1] - 1);
    }
}
