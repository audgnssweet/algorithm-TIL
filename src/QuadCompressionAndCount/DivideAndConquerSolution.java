package QuadCompressionAndCount;

public class DivideAndConquerSolution {

    static int[][] a;
    static int[] res = new int[2];

    public static int[] solution(int[][] arr) {
        a = arr;
        int xMax = a.length - 1;
        int yMax = a.length - 1;
        int target = a[yMax][xMax];

        int temp = arr.length;
        int n = 0;
        while (temp > 1) {
            temp /= 2;
            n += 1;
        }

        divideAndConquer(n, target, 0, 0, xMax, yMax);
        return res;
    }

    static void divideAndConquer(int n, int target, int xStart, int yStart, int xEnd, int yEnd) {
        if (n != 0) {
            for (int y = yStart; y <= yEnd; y++) {
                for (int x = xStart; x <= xEnd; x++) {
                    if (a[y][x] != target) {
                        int gap = (int) Math.pow(2, n - 1);
                        divideAndConquer(n - 1, a[yEnd - gap][xEnd - gap], xStart, yStart, xEnd - gap, yEnd - gap);
                        divideAndConquer(n - 1, a[yEnd - gap][xEnd], xEnd - gap + 1, yStart, xEnd, yEnd - gap);
                        divideAndConquer(n - 1, a[yEnd][xEnd - gap], xStart, yEnd - gap + 1, xEnd - gap, yEnd);
                        divideAndConquer(n - 1, a[yEnd][xEnd], xEnd - gap + 1, yEnd - gap + 1, xEnd, yEnd);
                        return;
                    }
                }
            }
        }
        res[target] += 1;
    }
}
