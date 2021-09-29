package TargetNumber;

public class Solution {

    static int res = 0;
    static int[] nums;
    static int tar;

    public static int solution(int[] numbers, int target) {
        res = 0;
        nums = numbers;
        tar = target;

        dfs(0, 0);

        return res;
    }

    static void dfs(int curPos, int cur) {
        if (curPos == nums.length) {
            if (cur == tar) {
                res += 1;
            }
        } else {
            dfs(curPos + 1, cur + nums[curPos]);
            dfs(curPos + 1, cur - nums[curPos]);
        }
    }

    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
