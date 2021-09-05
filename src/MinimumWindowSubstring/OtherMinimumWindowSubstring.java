package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class OtherMinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int i = 0, j = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int cnt = t.length(), start = 0;

        while (j < s.length()) {

            char cur = s.charAt(j);

            if (need.containsKey(cur)) {
                need.put(cur, need.get(cur) - 1);
                if (need.get(cur) >= 0) {
                    cnt--;
                }
            }

            while (cnt == 0) {
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    start = i;
                }
                char leftC = s.charAt(i);
                if (need.containsKey(leftC)) {
                    need.put(leftC, need.get(leftC) + 1);
                    if (need.get(leftC) >= 1) {
                        cnt++;
                    }
                }
                i++;
            }

            j++;
        }

        if (minLen > s.length()) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
