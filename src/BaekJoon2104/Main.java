package BaekJoon2104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        arr = new long[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(divideAndConquer(0, arr.length - 1));
    }

    private static long divideAndConquer(int start, int end) {
        if (start == end) {
            return arr[start] * arr[start];
        }

        int mid = start + (end - start) / 2;
        //왼쪽
        long left = divideAndConquer(start, mid);
        //오른쪽
        long right = divideAndConquer(mid + 1, end);
        //가운데
        int l = mid, r = mid;
        long sum = arr[mid], min = arr[mid], ans = 0;
        while (l > start && r < end) {
            //큰 쪽으로 전진하면서 갱신
            if (arr[r + 1] >= arr[l - 1]) {
                r++;
                sum += arr[r];
                min = Math.min(min, arr[r]);
            } else {
                l--;
                sum += arr[l];
                min = Math.min(min, arr[l]);
            }
            ans = Math.max(ans, sum * min);
        }

        //남은쪽으로 전진하면서 갱신
        while (l > start) {
            l--;
            sum += arr[l];
            min = Math.min(min, arr[l]);
            ans = Math.max(ans, sum * min);
        }

        while (r < end) {
            r++;
            sum += arr[r];
            min = Math.min(min, arr[r]);
            ans = Math.max(ans, sum * min);
        }

        return Math.max(ans, Math.max(left, right));
    }
}
