package AnticipatedMatch;

public class Solution {

    public int solution(int n, int a, int b)
    {
        int temp = n;
        int count = 0;
        while (temp > 1) {
            temp /= 2;
            count += 1;
        }

        while (n > 1) {
            n /= 2;

            if ((a <= n && b > n) || (b <= n && a > n)) {
                break;
            }

            if (a > n && b > n) {
                a -= n;
                b -= n;
            }
            count -= 1;
        }

        return count;
    }
}
