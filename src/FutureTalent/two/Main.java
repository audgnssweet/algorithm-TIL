package FutureTalent.two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {

        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static List<Edge>[] graph;
    //시작, 끝, 몇인지
    static int[] ans = {0, 0, 0};
    static boolean cycle = false;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        search(1, 0);
        if (cycle) {
            System.out.println(-1);
        } else {
            System.out.println(ans[2]);
            System.out.println(ans[0]);
            System.out.println(ans[1]);
        }
    }

    private static int[] search(int start, int weight) {
        if (visit[start]) {
            cycle = true;
            return null;
        }
        visit[start] = true;

        //leaf 노드라면 그냥 return
        if (graph[start].size() == 0) {
            return new int[]{start, weight};
        }

        //어디로부터, weight는 몇인지
        int[][] temp = new int[graph[start].size()][];
        for (int i = 0; i < graph[start].size(); i++) {
            Edge next = graph[start].get(i);
            temp[i] = search(next.vertex, next.weight);
            if (cycle) {
                return null;
            }
        }
        Arrays.sort(temp, (a1, a2) -> a1[1] - a2[1]);

        if (temp.length == 1) {
            if (ans[2] < temp[0][1]) {
                ans[0] = Math.min(temp[0][0], start);
                ans[1] = Math.max(temp[0][0], start);
                ans[2] = temp[0][1];
            }
            return new int[]{temp[0][0], temp[0][1] + weight};
        } else if (temp.length == 2) {
            if (ans[2] < temp[0][1] + temp[1][1]) {
                ans[0] = Math.min(temp[0][0], temp[1][0]);
                ans[1] = Math.max(temp[0][0], temp[1][0]);
                ans[2] = temp[0][1] + temp[1][1];
            }
            return new int[]{temp[1][0], temp[1][1] + weight};
        } else {
            if (ans[2] < temp[1][1] + temp[2][1]) {
                ans[0] = Math.min(temp[1][0], temp[2][0]);
                ans[1] = Math.max(temp[1][0], temp[2][0]);
                ans[2] = temp[1][1] + temp[2][1];
            }
            return new int[]{temp[2][0], temp[2][1] + weight};
        }
    }
}
