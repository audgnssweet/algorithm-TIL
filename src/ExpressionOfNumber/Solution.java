package ExpressionOfNumber;

public class Solution {

    public static int solution(int n) {
        int right = n % 2 == 1 ? n / 2 + 1 : n / 2, left, sum;
        sum = left = right;

        int count = 1;

        while (left >= 1) {
            if (sum == n) {
                count += 1;
                right -= 1;
                sum = left = right;
            } else if (sum > n) {
                sum -= right;
                right -= 1;
            } else {
                left -= 1;
                sum += left;
            }
        }

        return count;
    }
}
