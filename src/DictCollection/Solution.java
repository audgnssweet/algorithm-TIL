package DictCollection;

public class Solution {

    public static int solution(String word) {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        while (!sb.toString().equals(word)) {
            if (sb.length() < 5) {
                sb.append('A');
                ans += 1;
            } else {
                while (sb.charAt(sb.length() - 1) == 'U') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                char cur = sb.charAt(sb.length() - 1);
                sb.setCharAt(sb.length() - 1, getNext(cur));
                ans += 1;
            }
        }

        return ans;
    }

    static char getNext(char cur) {
        switch (cur) {
            case 'A':
                return 'E';
            case 'E':
                return 'I';
            case 'I':
                return 'O';
            default:
                return 'U';
        }
    }

    public static void main(String[] args) {
        solution("AAAAE");
    }
}
