package AssignCookies;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int gidx = 0, sidx = 0;
        int res = 0;
        while (gidx < g.length && sidx < s.length) {
            if (g[gidx] <= s[sidx]) {
                res += 1;
                gidx += 1;
            }
            sidx += 1;
        }

        return res;
    }
}
