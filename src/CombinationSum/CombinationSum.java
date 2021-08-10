package CombinationSum;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, 0, target);
        return res;
    }

    private void dfs(int[] nums, int sum, int start, int target) {
        if (sum == target) {
            res.add(new LinkedList<>(tmp));
        } else if (sum < target) {
            for (int i = start; i < nums.length; i++) {
                if (sum + nums[i] <= target) {
                    tmp.add(nums[i]);
                    dfs(nums, sum + nums[i], i, target);
                    tmp.removeLast();
                }
            }
        }
    }
}
