package NCountLeastCommonMultiple;

public class OtherSolution {

    public static int solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int gcd = gcd(arr[i], arr[i + 1]);
            arr[i + 1] = gcd * (arr[i] / gcd) * (arr[i + 1] / gcd);
        }

        return arr[arr.length - 1];
    }

    static int gcd(int n1, int n2) {
        int res = Math.max(n1, n2) % Math.min(n1, n2);
        return res == 0 ? Math.min(n1, n2) : gcd(Math.min(n1, n2), res);
    }
}
