package _Theory.플로이드와샬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    /**
     * 플로이드 와샬 알고리즘.
     * O(n^3) 의 복잡도를 갖고 있지만
     * 모든 점에서 모든 점으로의 최단 경로를 알아낼 수 있다.
     */

    public static void main(String[] args) throws IOException {
        //인접행렬 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        //O(N^3)
        //거쳐가는 노드
        for (int k = 0; k < N; k++) {
            //시작노드
            for (int start = 0; start < N; start++) {
                //도착 노드
                for (int end = 0; end < N; end++) {
                    //점화식. 거쳐가는 것이 더 비용이 적다면, 그렇게 해라
                    if (graph[start][k] + graph[k][end] < graph[start][end]) {
                        graph[start][end] = graph[start][k] + graph[k][end];
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                bw.write(graph[y][x] + " ");
            }
            bw.write('\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
