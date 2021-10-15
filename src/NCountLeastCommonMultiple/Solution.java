package NCountLeastCommonMultiple;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] arr) {
        Arrays.sort(arr);

        int res = arr[arr.length - 1];
        while (true) {
            boolean right = true;

            for (int i = 0; i < arr.length; i++) {
                if (res % arr[i] != 0) {
                    right = false;
                    break;
                }
            }

            if (right) {
                break;
            }
            res += 1;
        }

        return res;
    }
}
