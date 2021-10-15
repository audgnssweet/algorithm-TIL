package BaekJoon1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visit;
    static int vertNum;
    static int edgeNum;
    static int start;

    public static void main(String[] args) throws Exception {
        init();

        visit = new boolean[vertNum + 1];
        dfs(start, 0);
        System.out.println();
        visit = new boolean[vertNum + 1];
        bfs(start);
    }

    static void dfs(int curNode, int curPos) {
        System.out.print(curNode + " ");
        visit[curNode] = true;
        if (curPos != vertNum) {
            for (int next : graph[curNode]) {
                if (!visit[next]) {
                    dfs(next, curPos + 1);
                }
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int next : graph[cur]) {
                if (!visit[next]) {
                    q.offer(next);
                    visit[next] = true;
                }
            }
        }
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[vertNum + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        while (edgeNum > 0) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(edge.nextToken());
            int v2 = Integer.parseInt(edge.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
            edgeNum--;
        }

        for (int i = 1; i < graph.length; i++) {
            graph[i].sort((n1, n2) -> n1 - n2);
        }
    }
}
