package BaekJoon2448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] arr;
    static int[][] dPos = {
        {0, 0},
        {-1, 1},
        {-1, 1},
        {1, 0},
        {1, 0},
        {1, 0},
        {1, 0},
        {-1, -1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int height = Integer.parseInt(br.readLine());
        int width = (height / 3) * 5 + (height / 3) - 1;
        arr = new char[height][width];

        int startY = 0;
        int startX = width / 2;

        divideAndConquer(startX, startY, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                bw.write(arr[y][x] == '*' ? '*' : ' ');
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void divideAndConquer(int x, int y, int height) {
        if (height == 3) {
            makeStar(x, y);
        } else {
            int nextHeight = height / 2;
            divideAndConquer(x, y, nextHeight);
            divideAndConquer(x - nextHeight, y + nextHeight, nextHeight);
            divideAndConquer(x + nextHeight, y + nextHeight, nextHeight);
        }
    }

    private static void makeStar(int x, int y) {
        for (int i = 0; i < dPos.length; i++) {
            x += dPos[i][0];
            y += dPos[i][1];

            arr[y][x] = '*';
        }
    }
}
