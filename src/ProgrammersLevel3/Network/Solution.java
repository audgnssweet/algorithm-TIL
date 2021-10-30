package ProgrammersLevel3.Network;

public class Solution {

    static boolean[] visit;
    static int[][] arr;
    static int ans = 0;

    public static int solution(int n, int[][] computers) {
        visit = new boolean[n];
        arr = computers;
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                dfs(i);
                ans++;
            }
        }

        return ans;
    }

    private static void dfs(int cur) {
        visit[cur] = true;
        for (int i = 0; i < arr[cur].length; i++) {
            if (arr[cur][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
