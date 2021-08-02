package LongestSubStringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class OtherLongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int start, end;
        start = end = 0;
        while (end < chars.length) {
            if (map.containsKey(chars[end])) {
                start = Math.max(map.get(chars[end]) + 1, start);
                map.put(chars[end], end);
            } else {
                map.put(chars[end], end);
            }
            max = Math.max(end - start + 1, max);
            ++end;
        }

        return max;
    }
}
