package ProductOfArrayExceptSelf;

import java.util.Arrays;

public class LastProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        int leftTemp = 1;
        int rightTemp = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i] * leftTemp * nums[i - 1];
            res[res.length - 1 - i] = res[res.length - 1 - i] * rightTemp * nums[nums.length - i];
            leftTemp = leftTemp * nums[i - 1];
            rightTemp = rightTemp * nums[nums.length - i];
        }

        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

}
