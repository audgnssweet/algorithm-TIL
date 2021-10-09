package Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MySolution {

    //가중치 그래프이기 때문에 새로운 자료구조 선언 필요
    static class Edge {

        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    //다익스트라를 위해 필요한 자료구조 3개. 인접리스트, 방문여부표현, 정답을 저장할 배열
    static List<Edge>[] graph;
    static boolean[] visit;
    static Edge[] res;

    static void init(int N, int[][] road) {
        visit = new boolean[N + 1];

        res = new Edge[N + 1];
        res[1] = new Edge(1, 0);
        for (int i = 2; i <= N; i++) {
            res[i] = new Edge(i, Integer.MAX_VALUE);
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            graph[r[0]].add(new Edge(r[1], r[2]));
            graph[r[1]].add(new Edge(r[0], r[2]));
        }
    }

    public static int solution(int N, int[][] road, int K) {
        init(N, road);
        int count = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.offer(res[1]);

        while (!pq.isEmpty()) {
            Edge curNode = pq.poll();

            for (Edge next : graph[curNode.vertex]) {
                if (!visit[next.vertex] && res[next.vertex].weight >= res[curNode.vertex].weight + next.weight) {
                    res[next.vertex].weight = res[curNode.vertex].weight + next.weight;
                    pq.remove(res[next.vertex]);
                    pq.add(res[next.vertex]);
                }
                visit[curNode.vertex] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (res[i].weight <= K) {
                count += 1;
            }
        }
        return count;
    }

}
