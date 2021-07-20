package LongestPalindromicSubstring;

public class LongestPalindromicSubstring {

    public static  String longestPalindrome(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][i] = 1;
        }

        int start = 0, end = 0;
        for (int diag = 1; diag < s.length(); diag++) {
            int x = 1;
            for (int y = x + diag; y <= s.length(); y = x +diag) {
                if (dp[x][y - 1] == dp[x + 1][y]) {
                    dp[x][y] = process(s.substring(x - 1, y), y - x + 1);
                    if (dp[x][y] == 1) {
                        start = x - 1;
                        end = y;
                    }
                } else {
                    dp[x][y] = 0;
                }
                x++;
            }
        }

        if (start == end) {
            return s.substring(0, 1);
        } else {
            return s.substring(start, end);
        }
    }

    static int process(String s, int len) {
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }
}
