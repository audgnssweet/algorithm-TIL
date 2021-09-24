package NewsClustering;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NewsClustering {

    public int solution(String str1, String str2) {
        Map<String, Integer> map = new HashMap<>();

        String pattern = "(?=.*[^a-z]).*";
        int intersection = 0;
        int union = 0;

        for (int i = 0; i < str1.length() - 1; i++) {
            String cur = str1.substring(i, i + 2).toLowerCase();
            if (Pattern.matches(pattern, cur)) {
                continue;
            }
            int count = map.getOrDefault(cur, 0);
            map.put(cur, count + 1);
            union += 1;
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String cur = str2.substring(i, i + 2).toLowerCase();
            if (Pattern.matches(pattern, cur)) {
                continue;
            }

            if (map.containsKey(cur)) {
                int count = map.get(cur);
                if (count > 0) {
                    intersection += 1;
                    map.put(cur, count - 1);
                } else {
                    union += 1;
                }
            } else {
                union += 1;
            }
        }

        return union == 0 ? 65536 : 65536 * intersection / union;
    }
}
