package NnumberGame;

public class Solution {

    public static String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder("0");
        int len = t * m;

        int num = 0;
        while (all.length() < len) {
            int curNum = num;
            StringBuilder cur = new StringBuilder();

            while (curNum > 0) {
                int next = curNum % n;
                if (next > 9) {
                    cur.append((char) ('A' + next - 10));
                } else {
                    cur.append(next);
                }
                curNum /= n;
            }

            all.append(cur.reverse());
            ++num;
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < all.length() && res.length() < t) {
            if (i % m == p - 1) {
                res.append(all.charAt(i));
            }
            ++i;
        }

        return res.toString();
    }

}
