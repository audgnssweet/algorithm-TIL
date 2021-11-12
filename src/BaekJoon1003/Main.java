package BaekJoon1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] res = new int[2][41];

        res[0][0] = 1;
        res[1][1] = 1;
        for (int i = 2; i < res[0].length; i++) {
            res[0][i] = res[0][i - 1] + res[0][i - 2];
            res[1][i] = res[1][i - 1] + res[1][i - 2];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());
            bw.write(res[0][target] + " " + res[1][target] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
