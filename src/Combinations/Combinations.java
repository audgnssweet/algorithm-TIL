package Combinations;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> temp, int start, int n, int k) {
        if (temp.size() == k) {
            res.add(new LinkedList<>(temp));
        } else {
            for (int i = start; i <= n; i++) {
                temp.add(i);
                dfs(res, temp, i + 1, n, k);
                temp.removeLast();
            }
        }
    }

}
