package ClimbingStairs;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] res = new int[n];
        res[0] = 1; res[1] = 2;

        int idx = 2;
        while (idx < n) {
            res[idx] = res[idx - 1] + res[idx - 2];
            idx += 1;
        }

        return res[n - 1];
    }
}
