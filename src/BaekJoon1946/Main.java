package BaekJoon1946;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //테스트 케이스 개수만큼 실행
            int n = Integer.parseInt(br.readLine());
            int[] ranks = new int[n + 1];

            for (int line = 0; line < n; line++) {
                String[] info = br.readLine().split(" ");
                int rank1 = Integer.parseInt(info[0]);
                int rank2 = Integer.parseInt(info[1]);
                ranks[rank1] = rank2;
            }

            int recruitCount = 1;
            int deadLine = ranks[1];

            for (int j = 2; j < ranks.length; j++) {
                if (deadLine > ranks[j]) {
                    recruitCount++;
                    deadLine = ranks[j];
                }
            }

            System.out.println(recruitCount);
        }
    }
}
