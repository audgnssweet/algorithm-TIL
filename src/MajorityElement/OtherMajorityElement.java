package MajorityElement;

import java.util.Arrays;

public class OtherMajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
