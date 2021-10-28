package ProgrammersLevel3.FarthestNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {

    static List<Integer>[] graph;
    static boolean[] visit;

    public static int solution(int n, int[][] edge) {
        init(n, edge);

        return bfs();
    }

    static int bfs() {
        Stack<int[]> stack = new Stack<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visit[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            while (!stack.isEmpty() && stack.peek()[1] < cur[1]) {
                stack.pop();
            }
            stack.push(cur);

            for (int i = 0; i < graph[cur[0]].size(); ++i) {

                int next = graph[cur[0]].get(i);

                if (!visit[next]) {
                    visit[next] = true;

                    q.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        return stack.size();
    }

    static void init(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            int left = e[0];
            int right = e[1];

            graph[left].add(right);
            graph[right].add(left);
        }

        visit = new boolean[n + 1];
    }
}