package BaekJoon2839;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        Queue<Integer> q = new LinkedList<>();
        int size = target >= 5 ? target + 1 : 6;
        int[] res = new int[size];
        res[3] = res[5] = 1;
        q.offer(3);
        q.offer(5);

        int[] dValue = {3, 5};
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < dValue.length; i++) {
                int temp = cur + dValue[i];
                if (temp > target || res[temp] != 0) {
                    continue;
                }
                res[temp] = res[cur] + 1;
                q.offer(temp);
            }
        }
        System.out.println(res[target] == 0 ? -1 : res[target]);
    }
}
