package Permutations;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tmp = new LinkedList<>();
    int[][] arr;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return List.of(List.of(nums[0]));
        }

        arr = new int[2][nums.length];
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = nums[i];
        }

        for (int i = 0; i < arr[0].length; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs(int idx) {
        tmp.add(arr[0][idx]);
        arr[1][idx] = 1;
        if (tmp.size() == arr[0].length) {
            res.add(new LinkedList<>(tmp));
        } else {
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[1][i] == 0) {
                    dfs(i);
                }
            }
        }
        tmp.removeLast();
        arr[1][idx] = 0;
    }
}
