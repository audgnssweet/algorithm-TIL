package day_20211105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] place = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            place[i][0] = Integer.parseInt(st.nextToken());
            place[i][1] = Integer.parseInt(st.nextToken());
        }

        /**
         * 1 0 1
         * 0 1 0
         * 1 0 1
         * 4.00
         *
         * 0 0 1 0 0
         * 0 1 0 1 0
         * 1 0 0 0 1
         * 0 1 0 1 0
         * 0 0 1 0 0
         */
    }
}
