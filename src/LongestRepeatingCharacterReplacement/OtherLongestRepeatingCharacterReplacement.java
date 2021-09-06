package LongestRepeatingCharacterReplacement;

public class OtherLongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] arr = new int[26];
        int maxCount = 0, maxLen = 0, left = 0;
        for (int right = 0; right < len; right++) {
            maxCount = Math.max(maxCount, ++arr[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
