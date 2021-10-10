package PivonachNumber;

public class Solution {

    public int solution(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] piv = new int[n + 1];
        piv[0] = 0;
        piv[1] = 1;

        for (int i = 2; i <= n; i++) {
            piv[i] = (piv[i - 1] + piv[i - 2]) % 1234567;
        }

        return piv[n];
    }
}
