package JoyStick;

public class Solution {

    static char[] arr;

    public static int solution(String name) {
        arr = name.toCharArray();
        int nonA = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'A') {
                nonA += 1;
            }
        }

        int count = 0;
        int cur = 0;
        while (true) {
            if (arr[cur] != 'A') {
                count += Math.min(arr[cur] - 'A', 'Z' - arr[cur] + 1);
                arr[cur] = 'A';
                nonA -= 1;
            }

            if (nonA == 0) {
                break;
            }

            int left = cur, leftCnt = 0;
            while (arr[left] == 'A') {
                left = left == 0 ? arr.length - 1 : left - 1;
                leftCnt += 1;
            }

            int right = cur, rightCnt = 0;
            while (arr[right] == 'A') {
                right = right == arr.length - 1 ? 0 : right + 1;
                rightCnt += 1;
            }

            if (leftCnt < rightCnt) {
                cur = left;
                count += leftCnt;
            } else {
                cur = right;
                count += rightCnt;
            }

        }

        return count;
    }

}
