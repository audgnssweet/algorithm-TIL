package NetworkDelayTime;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraNDT {

    final int INF = Integer.MAX_VALUE;
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] t : times) {
            map.computeIfAbsent(t[0],
                absent -> new HashMap<>()
            ).put(t[1], t[2]);
        }

        int[] res = new int[n + 1];
        Arrays.fill(res, INF);
        res[k] = 0;

        queue.add(new int[]{k, 0});
        while (!queue.isEmpty() && visit.size() != n) {
            final int[] cur = queue.poll();

            final Map<Integer, Integer> nexts = this.map.get(cur[0]);

            if (nexts != null) {

                for (Integer next : nexts.keySet()) {
                    int weight = nexts.get(next);
                    if (res[next] > cur[1] + weight) {
                        res[next] = cur[1] + weight;
                        queue.add(new int[]{next, res[next]});
                    }
                }

            }

            visit.add(cur[0]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, res[i]);
        }

        return max != INF ? max : -1;
    }
}
