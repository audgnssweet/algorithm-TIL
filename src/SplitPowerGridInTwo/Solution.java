package SplitPowerGridInTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    static List<Integer>[] graph;

    public static int solution(int n, int[][] wires) {
        init(n, wires);
        int min = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));

            min = Math.min(min, Math.abs(bfs(wire[0], new boolean[n + 1]) - bfs(wire[1], new boolean[n + 1])));

            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        return min;
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
    }

    static int bfs(int start, boolean[] visit) {
        int count = 0;

        visit[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            count += 1;

            for (int nextPos : graph[cur]) {
                if (!visit[nextPos]) {
                    visit[nextPos] = true;
                    q.offer(nextPos);
                }
            }
        }

        return count;
    }
}
