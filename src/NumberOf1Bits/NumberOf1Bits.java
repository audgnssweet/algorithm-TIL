package NumberOf1Bits;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int mask = 1;
        int cnt = 0;
        int res = 0;

        while (cnt < 32) {
            if ((mask & n) != 0) {
                ++res;
            }
            ++cnt;
            mask <<= 1;
        }
        return res;
    }
}
