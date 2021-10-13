package KMP;

public class Solution {

    public static void main(String[] args) {
        solution("CC#BCC#BCC#BCC#B", "BCC");
    }

    static int[] pi;
    static int result;

    public static void solution(String origin, String pattern) {
        pi = new int[pattern.length()];
        getPi(pattern);
        KMP(origin, pattern);
    }

    private static void getPi(String pattern) {
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (pattern.charAt(i) == pattern.charAt(j)) {
                //i길이 문자열의 공통 길이는 j의 위치 + 1
                pi[i] = ++j;
            }
        }
    }

    private static void KMP(String origin, String pattern) {
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    result = i;
                    break;
                }
                //맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
                else {
                    ++j;
                }
            }
        }
        System.out.println(result);
    }
}
