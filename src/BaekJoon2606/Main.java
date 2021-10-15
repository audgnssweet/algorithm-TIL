package BaekJoon2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int vNum;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        init();

        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        boolean[] visit = new boolean[vNum + 1];
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        int ans = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans += 1;

            for (int next : graph[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.offer(next);
                }
            }
        }
        return ans;
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vNum = Integer.parseInt(br.readLine());
        int eNum = Integer.parseInt(br.readLine());

        graph = new ArrayList[vNum + 1];
        for (int i = 1; i <= vNum; i++) {
            graph[i] = new ArrayList<>();
        }
        while (eNum > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);

            eNum--;
        }
    }
}
