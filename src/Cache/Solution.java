package Cache;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int res = 0;
        for (int idx = 0; idx < cities.length; ++idx) {

            String cur = cities[idx].toLowerCase();
            if (q.contains(cur)) {
                res += 1;
                q.remove(cur);
            } else {
                res += 5;
            }
            q.offer(cur);

            if (q.size() > cacheSize) {
                q.poll();
            }
        }

        return res;
    }
}
