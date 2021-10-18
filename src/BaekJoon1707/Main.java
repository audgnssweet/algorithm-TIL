package BaekJoon1707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        for (int c = 0; c < caseNum; c++) {
            //인접리스트 만들기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vNum = Integer.parseInt(st.nextToken());
            int eNum = Integer.parseInt(st.nextToken());
            graph = new ArrayList[vNum + 1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            visit = new int[vNum + 1];

            for (int i = 0; i < eNum; i++) {
                StringTokenizer edge = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(edge.nextToken());
                int right = Integer.parseInt(edge.nextToken());

                graph[left].add(right);
                graph[right].add(left);
            }

            //본격적 탐색
            bfs();
        }
    }

    private static void bfs() {
        int start = 1;
        while (true) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            visit[start] = 1;

            boolean fail = false;
            while (!fail && !q.isEmpty()) {
                int curNode = q.poll();
                int curColor = visit[curNode];

                for (int i = 0; i < graph[curNode].size(); i++) {
                    int nextNode = graph[curNode].get(i);
                    if (visit[nextNode] == 0) {
                        //이어졌는데 방문 안한 경우
                        q.offer(nextNode);
                        visit[nextNode] = curColor == 1 ? 2 : 1;
                    } else if (visit[nextNode] == curColor) {
                        //방문을 했는데 같아서 문제가 있는경우
                        fail = true;
                    }
                }
            }

            if (fail) {
                System.out.println("NO");
                break;
            }

            start = 0;
            for (int i = 1; i < visit.length; i++) {
                if (visit[i] == 0) {
                    start = i;
                }
            }

            if (start == 0) {
                System.out.println("YES");
                break;
            }
        }
    }
}