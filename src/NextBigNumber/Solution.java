package NextBigNumber;

public class Solution {

    public int solution(int n) {
        int i = 1;
        while (Integer.bitCount(n + i) != Integer.bitCount(n)) {
            ++i;
        }
        return n + i;
    }
}
