package JumpAndTeleporting;

public class Solution {

    public int solution(int n) {
        int res = 0;
        while (n > 1) {
            while (n % 2 == 0) {
                n /= 2;
            }
            n -= 1;
            res += 1;
        }
        return res == 0 ? 1 : res;
    }
}
