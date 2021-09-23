package Cache;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cache {

    final int HIT = 1;
    final int MISS = 5;

    public int cache(int cacheSize, List<String> cities) {
        if (cacheSize == 0) {
            return MISS * cities.size();
        }
        int res = 5;
        int left = 0, right = 1;
        Set<String> cacheSet = new HashSet<>();
        cacheSet.add(cities.get(0).toLowerCase());

        while (right < cities.size() && right - left < cacheSize) {
            if (cacheSet.contains(cities.get(right).toLowerCase())) {
                res += HIT;
            } else {
                res += MISS;
            }
            cacheSet.add(cities.get(right).toLowerCase());
            right += 1;
        }

        while (right < cities.size()) {
            if (cacheSet.contains(cities.get(right).toLowerCase())) {
                res += HIT;
            } else {
                res += MISS;
            }
            cacheSet.remove(cities.get(left).toLowerCase());
            cacheSet.add(cities.get(right).toLowerCase());
            left += 1;
            right += 1;
        }

        return res;
    }
}
