package Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    static class Edge {

        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visit;
    static Edge[] edges;

    static void init(int N, int[][] road) {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : road) {
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        edges = new Edge[N + 1];
        edges[1] = new Edge(1, 0);
        for (int i = 2; i <= N; i++) {
            edges[i] = new Edge(i, Integer.MAX_VALUE);
        }

        visit = new boolean[N + 1];
    }

    public static int solution(int N, int[][] road, int K) {
        init(N, road);
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
        for (int i = 1; i < edges.length; i++) {
            //edge를 직접 넣어준다.
            pq.offer(edges[i]);
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Edge next : graph.get(cur.v)) {
                //기존꺼랑 비교해서 새로운게 더 작으면 바꿔줌
                if (!visit[next.v] && edges[next.v].w > edges[cur.v].w + next.w) {
                    //PQ 안의 값을 직접번경해주기 때문에 메모리를 아낄 수 있음.
                    edges[next.v].w = edges[cur.v].w + next.w;
                    //값이 바뀌면 재정렬을 해주어야 한다.
                    pq.remove(edges[next.v]);
                    pq.add(edges[next.v]);
                }
            }
            visit[cur.v] = true;
        }

        int res = 0;
        for (int i = 1; i < edges.length; i++) {
            if (edges[i].w <= K) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        solution(5, new int[][]{
            {1, 2, 1},
            {2, 3, 3},
            {5, 2, 2},
            {1, 4, 2},
            {5, 3, 1},
            {5, 4, 2}
        }, 3);
    }
}
