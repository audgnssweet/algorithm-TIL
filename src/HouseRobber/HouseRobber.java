package HouseRobber;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int curmax = nums[0];
        int res = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (curmax < nums[i - 2]) {
                curmax = nums[i - 2];
            }
            nums[i] += curmax;
            res = Math.max(res, nums[i]);
        }

        return res;
    }

}
