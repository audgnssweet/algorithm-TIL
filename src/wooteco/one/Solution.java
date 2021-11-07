package wooteco.one;

public class Solution {

    public int[] solution(int[] arr) {
        int[] counts = new int[4];
        for (int num : arr) {
            counts[num]++;
        }

        int maxCount = Math.max(counts[1], Math.max(counts[2], counts[3]));
        int[] ans = new int[3];
        for (int i = 1; i < counts.length; i++) {
            ans[i - 1] = maxCount - counts[i];
        }

        return ans;
    }
}
