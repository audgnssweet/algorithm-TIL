package CheapestFlightsWithinKStops;

import java.util.Arrays;

//Bellman Ford Algo
public class OtherCheapestFlightsWithinKStops {

    final int INF = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res = new int[n];
        Arrays.fill(res, INF);
        res[src] = 0;

        for (int i = 0; i <= k; i++) {
            boolean anyChanged = false;

            int[] cur = res.clone();

            for (int[] f : flights) {
                int now = f[0], next = f[1], nextWeight = f[2];

                //이부분이 핵심
                if (res[now] != INF && cur[next] > res[now] + nextWeight) {
                    cur[next] = res[now] + nextWeight;
                    anyChanged = true;
                }
            }

            if (!anyChanged) {
                break;
            }

            res = cur;
        }

        return res[dst] != INF ? res[dst] : -1;
    }

}
