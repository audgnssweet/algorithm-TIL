package BaekJoon2447;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] res;
    static int[][] rounds = new int[][]{
        {0, 0},
        {0, 1},
        {0, 1},
        {1, 0},
        {1, 0},
        {0, -1},
        {0, -1},
        {-1, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());

        res = new char[len][len];

        divideAndConquer(len, 0, 0);

        for (int y = 0; y < len; y++) {
            for (int x = 0; x < len; x++) {
                bw.write(res[y][x] == '*' ? '*' : ' ');
            }
            bw.write('\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void divideAndConquer(int len, int startX, int startY) {
        if (len == 3) {
            for (int i = 0; i < rounds.length; i++) {
                startX += rounds[i][0];
                startY += rounds[i][1];

                res[startY][startX] = '*';
            }
            return;
        }

        int nextLen = len / 3;
        for (int i = 0; i < rounds.length; i++) {
            startX += (nextLen * rounds[i][0]);
            startY += (nextLen * rounds[i][1]);

            divideAndConquer(nextLen, startX, startY);
        }
    }
}
