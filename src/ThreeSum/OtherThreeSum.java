package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left, right, sum;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    ++left;
                } else if (sum > 0) {
                    --right;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                }
            }
        }
        return result;
    }
}
