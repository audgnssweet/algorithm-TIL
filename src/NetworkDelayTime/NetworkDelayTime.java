package NetworkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {

    //for result
    Map<Integer, List<List<Integer>>> map = new HashMap<>();

    //for inf value
    final int INF = Integer.MAX_VALUE;

    //for initialize
    final int I_NODE = 0;
    final int I_NEXT_NODE = 1;
    final int I_WEIGHT = 2;

    //for map
    final int NEXT_NODE = 0;
    final int NEXT_WEIGHT = 1;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] res = new int[n + 1];
        int[] visit = new int[n + 1];
        Arrays.fill(res, INF);
        res[k] = 0;

        for (int[] info : times) {
            map.computeIfAbsent(info[I_NODE], absent -> new ArrayList<>())
                .add(List.of(info[I_NEXT_NODE], info[I_WEIGHT]));
        }

        while (map.size() != 0) {
            int min = INF;
            int cur = 0;
            for (int i = 1; i <= n; i++) {
                if (res[i] < min && visit[i] == 0) {
                    min = res[i];
                    cur = i;
                }
            }

            if (cur == 0) {
                break;
            }
            visit[cur] = 1;

            final List<List<Integer>> nexts = map.get(cur);
            if (nexts != null) {
                for (List<Integer> next : nexts) {
                    res[next.get(NEXT_NODE)] = Math.min(
                        res[next.get(NEXT_NODE)],
                        res[cur] + next.get(NEXT_WEIGHT)
                    );
                }
                map.remove(cur);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, res[i]);
        }

        return max != INF ? max : -1;
    }
}
