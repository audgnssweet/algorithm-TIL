package LongestSubStringWithoutRepeatingCharacters;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int max = 0;
        final char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars.length - i <= max) {
                break;
            }
            set.clear();
            set.add(chars[i]);
            int k = i + 1;
            while (k < chars.length) {
                if (set.contains(chars[k])) {
                    break;
                }
                set.add(chars[k]);
                ++k;
            }
            --k;
            max = Math.max(k - i + 1, max);
        }

        return max;
    }

}
