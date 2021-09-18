package FibonacciNumber;

public class FibonacciNumber {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0; fibonacci[1] = 1;


        for (int i = 2; i <= n; i++) {
            if (i == n) {
                return fibonacci[n - 1] + fibonacci[n - 2];
            }
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return -1;
    }
}
