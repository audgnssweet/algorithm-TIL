package SumOfTwoIntegers;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int up = 0;
        int idx = 0;
        int res = 0;

        while (idx < 32) {
            int bitA = (a & (1 << idx));
            int bitB = (b & (1 << idx));

            if ((bitA == bitB) && (bitA != 0)) {
                if (up == 1) {
                    res |= (1 << idx);
                }
                up = 1;
            }

            if ((bitA == bitB) && (bitA == 0)) {
                if (up == 1) {
                    res |= (1 << idx);
                    up = 0;
                }
            }

            if (bitA != bitB) {
                if (up != 1) {
                    res |= (1 << idx);
                }
            }

            idx += 1;
        }

        return res;
    }

}
