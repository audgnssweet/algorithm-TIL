package Carpet;

public class Solution {

    public int[] solution(int brown, int yellow) {
        int allCount = brown + yellow;
        for (int height = 3; height < allCount / 2; height++) {
            if (allCount % height == 0) {
                int width = allCount / height;
                if ((height * 2) + (width - 2) * 2 == brown) {
                    return new int[]{allCount / height, height};
                }
            }
        }
        return null;
    }
}
