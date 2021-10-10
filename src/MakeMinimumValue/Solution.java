package MakeMinimumValue;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            res += (A[i] * B[B.length - 1 - i]);
        }

        return res;
    }
}
