package Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RealSolution {

    static class Edge implements Comparable<Edge> {

        int vert;
        int weight;

        public Edge(int vert, int weight) {
            this.vert = vert;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return weight - other.weight;
        }
    }

    private static List<Edge>[] graph;
    private static boolean[] visit;
    private static Edge[] res;
    private static PriorityQueue<Edge> pq;

    public static int solution(int N, int[][] road, int K) {
        init(N, road);

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            visit[cur.vert] = true;

            for (Edge next : graph[cur.vert]) {
                if (res[next.vert].weight > cur.weight + next.weight) {
                    pq.remove(res[next.vert]);
                    res[next.vert].weight = cur.weight + next.weight;
                    if (!visit[next.vert]) {
                        pq.offer(res[next.vert]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i].weight <= K) {
                ++ans;
            }
        }

        return ans;
    }

    private static void init(int N, int[][] road) {
        graph = new ArrayList[N + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] verts : road) {
            int left = verts[0], right = verts[1], weight = verts[2];
            graph[left].add(new Edge(right, weight));
            graph[right].add(new Edge(left, weight));
        }

        pq = new PriorityQueue<>();
        res = new Edge[N + 1];
        res[1] = new Edge(1, 0);
        pq.add(res[1]);
        for (int i = 2; i < res.length; i++) {
            res[i] = new Edge(i, Integer.MAX_VALUE);
            pq.add(res[i]);
        }

        visit = new boolean[N + 1];
    }
}
