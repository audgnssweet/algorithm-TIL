package Baekjoon11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 10000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //그래프 초기화
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (y != x) {
                    graph[y][x] = INF;
                }
            }
        }

        int numOfBus = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfBus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start - 1][end - 1] = Math.min(graph[start - 1][end - 1], weight);
        }

        //거쳐가는 점
        floydWarshall(N, graph);
        print(bw, N, graph);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void print(BufferedWriter bw, int N, int[][] graph) throws IOException {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (graph[y][x] >= INF) {
                    bw.write(0 + " ");
                } else {
                    bw.write(graph[y][x] + " ");
                }
            }
            bw.write('\n');
        }
    }

    private static void floydWarshall(int N, int[][] graph) {
        for (int k = 0; k < N; k++) {
            //시작점
            for (int start = 0; start < N; start++) {
                //끝점
                for (int end = 0; end < N; end++) {
                    if (graph[start][k] + graph[k][end] < graph[start][end]) {
                        graph[start][end] = graph[start][k] + graph[k][end];
                    }
                }
            }
        }
    }
}
