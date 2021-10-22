package BaekJoon5904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int level = 0;
        int len = 3;
        while (N > len) {
            level++;
            len = len * 2 + 1 + level + 2;
        }

        System.out.println(divideAndConquer(N, level, len));
    }

    static char divideAndConquer(int target, int level, int len) {
        int mid = level + 3;
        len = (len - mid) / 2;
        target = target > len + mid ? target - (mid + len) : target;

        if (target <= len || target > len + mid) {
            return divideAndConquer(target, level - 1, len);
        }

        return target == len + 1 ? 'm' : 'o';
    }
}
