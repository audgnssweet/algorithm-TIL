package ProgrammersLevel3.Immigration;

import java.util.Arrays;

public class Solution {

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0, end = Long.MAX_VALUE;

        while (start < end) {
            long mid = start + (end - start) / 2;

            long maxCount = 0;
            for (int i = 0; i < times.length; i++) {
                if (maxCount >= n || times[i] > mid) {
                    break;
                }
                maxCount += (mid / times[i]);
            }

            if (maxCount >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

}
