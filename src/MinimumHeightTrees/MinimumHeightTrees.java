package MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {

    Set<Integer> visit = new HashSet<>();
    Set<Integer> duplicate = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] res;
    int tmp = 0;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], absent -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], absent -> new ArrayList<>()).add(e[0]);
        }

        res = new int[n];

        for (int i = 0; i < n; i++) {
            dfs(n, i, i, 0);
            visit.clear();
            duplicate.clear();
            tmp = 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            min = Math.min(min, res[i]);
        }

        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == min) {
                r.add(i);
            }
        }

        return r;
    }

    private void dfs(int n, int start, int vert, int depth) {
        if (duplicate.contains(vert)) {
            return;
        }
        duplicate.add(vert);
        visit.add(vert);

        List<Integer> nexts = graph.get(vert);

        tmp = Math.max(tmp, depth);
        if (visit.size() == n) {
            res[start] = tmp;
            return;
        }

        for (Integer next : nexts) {
            dfs(n, start, next, depth + 1);
        }
    }
}
