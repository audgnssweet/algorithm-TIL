package MinimumHeightTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OtherMinimumHeightTrees {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Set<Integer> leaves = new HashSet<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], absent -> new HashSet<>()).add(e[1]);
            graph.computeIfAbsent(e[1], absent -> new HashSet<>()).add(e[0]);
        }

        while (true) {
            leaves.clear();

            for (Integer key : graph.keySet()) {
                if (graph.get(key).size() == 1 || graph.get(key).size() == 0) {
                    leaves.add(key);
                }
            }

            for (Integer leaf : leaves) {
                graph.remove(leaf);
            }
            if (graph.isEmpty()) {
                break;
            }

            for (Integer key : graph.keySet()) {
                graph.get(key).removeAll(leaves);
            }
        }

        return new LinkedList<>(leaves);
    }

    public static void main(String[] args) {
        OtherMinimumHeightTrees omh = new OtherMinimumHeightTrees();
        omh.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }
}
