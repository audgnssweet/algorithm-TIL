package NumberOf1Bits;

public class OtherNumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count += 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

}
