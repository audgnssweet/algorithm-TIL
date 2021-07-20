package LongestPalindromicSubstring;

public class OtherLongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        final char[] chars = s.toCharArray();
        String result = "" + chars[0];
        int maxLen = 1;

        for (int i = 0; i < chars.length - 1; i++) {
            //홀수
            int offset = 0;
            int thisLen = 0;
            while (i - offset >= 0 && i + offset < s.length() && chars[i-offset] == chars[i+offset]) {
                ++offset;
            }
            --offset;
            thisLen = offset * 2 + 1;
            if (maxLen < thisLen) {
                maxLen = thisLen;
                result = s.substring(i - offset, i + offset + 1);
            }
            //짝수
            offset = 0;
            thisLen = 0;
            while (i + 1 - offset >= 0 && i + offset < s.length() && chars[i + 1 - offset] == chars[i + offset]) {
                ++offset;
            }
            --offset;
            thisLen = offset * 2;
            if (maxLen < thisLen) {
                maxLen = thisLen;
                result = s.substring(i + 1 - offset, i + offset + 1);
            }
        }
        return result;
    }
}
