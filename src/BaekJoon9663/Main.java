package BaekJoon9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int ans = 0;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];

        dfs(0, N);
        System.out.println(ans);
    }

    static void dfs(int curPos, int N) {
        if (curPos == N) {
            ans += 1;
        } else {
            for (int i = 0; i < N; i++) {
                if (check(curPos, i)) {
                    visit[i] = true;
                    arr[curPos] = i;
                    dfs(curPos + 1, N);
                    visit[i] = false;
                }
            }
        }
    }

    static boolean check(int curPos, int num) {
        if (visit[num]) {
            return false;
        }
        for (int i = 1; i <= curPos; i++) {
            if (arr[curPos - i] == num - i || arr[curPos - i] == num + i) {
                return false;
            }
        }
        return true;
    }
}
