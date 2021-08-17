package NetworkDelayTime;

import java.util.Arrays;

public class BellmanFordNDT {

    final int INF = Integer.MAX_VALUE;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] res = new int[n + 1];
        Arrays.fill(res, INF);
        res[k] = 0;

        while (true) {
            boolean anyUpdate = false;
            int[] cur = res.clone();

            for (int[] t : times) {
                int from = t[0], to = t[1], weight = t[2];
                if (res[from] != INF && cur[to] > res[from] + weight) {
                    cur[to] = res[from] + weight;
                    anyUpdate = true;
                }
            }

            if (!anyUpdate) {
                break;
            }

            res = cur;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, res[i]);
        }

        return max != INF ? max : -1;
    }
}
