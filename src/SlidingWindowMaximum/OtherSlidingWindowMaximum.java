package SlidingWindowMaximum;

public class OtherSlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int left = 0, maxIdx = 0;
        int idx = 0;

        for (int i = left; i <= k - 1; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        res[idx++] = max;

        for (int i = k; i < nums.length; i++) {
            if (maxIdx == left) {

                max = Integer.MIN_VALUE;
                for (int j = left + 1; j <= i; j++) {
                    if (max <= nums[j]) {
                        max = nums[j];
                        maxIdx = j;
                    }
                }

            } else {

                if (max <= nums[i]) {
                    max = nums[i];
                    maxIdx = i;
                }

            }

            res[idx++] = max;
            left += 1;
        }

        return res;
    }


    public static void main(String[] args) {
        OtherSlidingWindowMaximum osm = new OtherSlidingWindowMaximum();
        osm.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
