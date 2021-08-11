package Subsets;

import java.util.LinkedList;
import java.util.List;

public class Subsets {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new LinkedList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(nums, i + 1);
            tmp.removeLast();
        }
    }
}
