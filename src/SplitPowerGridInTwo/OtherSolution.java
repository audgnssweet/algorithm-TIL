package SplitPowerGridInTwo;

import java.util.ArrayList;
import java.util.List;

public class OtherSolution {

    static List<Integer>[] graph;
    static boolean[] visit;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static int solution(int n, int[][] wires) {
        init(n, wires);
        dfs(1);
        return ans;
    }

    static void init(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        visit = new boolean[n + 1];
        N = n;
    }

    static int dfs(int n) {
        visit[n] = true;
        int nodes = 1;

        for (Integer next : graph[n]) {
            if (!visit[next]) {
                nodes += dfs(next);
            }
        }

        ans = Math.min(ans, Math.abs(N - (nodes * 2)));
        return nodes;
    }
}
