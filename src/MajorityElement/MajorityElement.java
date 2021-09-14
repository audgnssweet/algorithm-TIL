package MajorityElement;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int max = nums.length / 2;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right += 1;
                continue;
            }
            if (right - left > max) {
                return nums[left];
            } else {
                left = right;
            }
        }

        return right - left > max ? nums[left] : -1;
    }
}
