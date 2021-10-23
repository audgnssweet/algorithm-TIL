package NHN_20211023_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NandK = br.readLine().split(" ");
        int N = Integer.parseInt(NandK[0]);
        int K = Integer.parseInt(NandK[1]);
        int[] arr = new int[21];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> (a1[1] - a2[1]) * -1);
        for (int i = 1; i <= 20; i++) {
            pq.offer(new int[]{i, arr[i]});
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            ans += pq.poll()[1];
        }
        System.out.println(ans);
    }
}
