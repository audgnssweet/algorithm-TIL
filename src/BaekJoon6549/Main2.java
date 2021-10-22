package BaekJoon6549;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {

    static int[] histogram;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            init(br);

            if (histogram.length == 0) {
                break;
            }
            long ans = divideAndConquer(0, histogram.length - 1);
            bw.write(ans + "\n");

            histogram = null;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long divideAndConquer(int left, int right) {
        if (left == right) {
            return histogram[left];
        }

        int mid = (right - left) / 2 + left;
        long one = divideAndConquer(left, mid);
        long two = divideAndConquer(mid + 1, right);

        long three = 0;
        int l = mid, r = mid;
        long curMin = histogram[mid];
        while (l > left && r < right) {
            //양쪽 다 끝에 안닿은 경우
            //더 큰 쪽으로 전진하고 갱신
            if (histogram[l - 1] <= histogram[r + 1]) {
                r++;
                curMin = Math.min(curMin, histogram[r]);
            } else {
                l--;
                curMin = Math.min(curMin, histogram[l]);
            }
            three = Math.max(three, (r - l + 1) * curMin);
        }

        //왼쪽만 끝에 닿은 경우
        while (r < right) {
            r++;
            curMin = Math.min(curMin, histogram[r]);
            three = Math.max(three, (r - l + 1) * curMin);
        }

        //오른쪽만 끝에 닿은 경우
        while (l > left) {
            l--;
            curMin = Math.min(curMin, histogram[l]);
            three = Math.max(three, (r - l + 1) * curMin);
        }

        return Math.max(one, Math.max(two, three));

    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        histogram = new int[Integer.parseInt(st.nextToken())];
        while (st.hasMoreTokens()) {
            histogram[idx++] = Integer.parseInt(st.nextToken());
        }
    }
}
