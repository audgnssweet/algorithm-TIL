package day_20211105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dots = new int[2][2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }

        int first = Math.abs(dots[1][0] - dots[0][0]);
        int second = Math.abs(dots[1][1] - dots[0][1]);

        if (first == 0 && second == 0) {
            System.out.println("DOT");
        } else if (first == second) {
            System.out.println("SQUARE");
        } else if (first == 0 || second == 0) {
            System.out.println("SEGMENT");
        } else {
            System.out.println("RECTANGLE");
        }
    }
}
