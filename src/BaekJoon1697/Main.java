package BaekJoon1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (start == end) {
            System.out.println(0);
            return;
        }

        int[] visit = new int[100001];
        visit[start] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                System.out.println(visit[cur] - 1);
                return;
            }

            if (cur - 1 >= 0 && visit[cur - 1] == 0) {
                visit[cur - 1] = visit[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur + 1 <= 100000 && visit[cur + 1] == 0) {
                visit[cur + 1] = visit[cur] + 1;
                q.offer(cur + 1);
            }
            if (cur * 2 <= 100000 && visit[cur * 2] == 0) {
                visit[cur * 2] = visit[cur] + 1;
                q.offer(cur * 2);
            }
        }
    }
}
