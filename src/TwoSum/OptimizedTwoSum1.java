package TwoSum;

import java.util.HashMap;
import java.util.Map;

public class OptimizedTwoSum1 {

    //3ms
    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(target - nums[i]);
            if (result != null && result != i) {
                return new int[]{i, result};
            }
        }

        return null;
    }

}
