package BaekJoon1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[1] == a2[1]) {
                return a1[0] - a2[0];
            }
            return a1[1] - a2[1];
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int ans = 0;
        int endTime = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] < endTime) {
                continue;
            }

            ans++;
            endTime = cur[1];
        }

        System.out.println(ans);
    }
}
