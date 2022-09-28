package Hindex;

import java.util.Arrays;

public class Solution2 {

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int res = citations[citations.length - 1];
        while (res > 0) {
            int idx = Arrays.binarySearch(citations, res);
            idx = idx >= 0 ? idx : Math.abs(idx + 1);
            if (citations.length - idx >= res) {
                break;
            }

            res -= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        solution(new int[]{3, 0, 6, 1, 5});
    }
}
