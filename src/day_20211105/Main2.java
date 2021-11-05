package day_20211105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int numberOfPapers = Integer.parseInt(br.readLine());
            int[][] info = new int[numberOfPapers][2];
            StringTokenizer st;
            for (int j = 0; j < numberOfPapers; j++) {
                st = new StringTokenizer(br.readLine());
                info[j][0] = Integer.parseInt(st.nextToken());
                info[j][1] = Integer.parseInt(st.nextToken());
            }

            //싫행
            System.out.println(getArea(numberOfPapers, info));
        }
    }

    private static int getArea(int numberOfPapers, int[][] info) {
        int[][] arr = new int[101][101];
        for (int[] i : info) {
            int xStart = i[0];
            int yStart = i[1];

            for (int y = yStart; y < yStart + 10; y++) {
                for (int x = xStart; x < xStart + 10; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        int ans = 0;
        for (int y = 1; y < 101; y++) {
            for (int x = 1; x < 101; x++) {
                if (arr[y][x] == 1) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}
