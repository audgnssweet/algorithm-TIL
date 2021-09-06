package LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        int maxLen = 0;
        char maxC = s.charAt(0);

        int left = 0;
        int[] map = new int[26];

        for (int cur = 0; cur < s.length(); cur++) {

            while (cur < s.length()) {
                char curC = s.charAt(cur);
                map[curC - 'A'] += 1;

                if (map[maxC - 'A'] < map[curC - 'A']) {
                    maxC = curC;
                }

                if (maxC != curC) {
                    k -= 1;
                }
                if (k < 0) {
                    break;
                }

                maxLen = Math.max(maxLen, cur - left + 1);
                cur += 1;
            }

            while (k < 0) {
                char leftC = s.charAt(left);
                left += 1;
                map[leftC - 'A'] -= 1;

                maxC = findMax(map, maxC);

                if (leftC != maxC) {
                    k += 1;
                }
            }
        }

        return maxLen;
    }

    private char findMax(int[] map, char maxC) {
        int max = map[maxC - 'A'];
        int maxIdx = -1;
        for (int i = 0; i < map.length; i++) {
            if (max < map[i] && ((i + 'A') != maxC)) {
                max = map[i];
                maxIdx = i;
            }
        }
        return maxIdx == -1 ? maxC : (char) ('A' + maxIdx);
    }

}
