package BaekJoon10844;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] res = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 2; i <= N; i++) {
            int[] temp = new int[10];
            for (int j = 0; j < res.length; j++) {
                if (j == 0) {
                    //0이면 1로밖에 못감
                    temp[1] = (temp[1] + res[0]) % 1000000000;
                } else if (j == 9) {
                    //9면 8로밖에 못감
                    temp[8] = (temp[8] + res[9]) % 1000000000;
                } else {
                    //아니면 작은수, 큰수로 갈 수 있음
                    temp[j - 1] = (temp[j - 1] + res[j]) % 1000000000;
                    temp[j + 1] = (temp[j + 1] + res[j]) % 1000000000;
                }
            }
            res = temp;
        }

        int ans = 0;
        for (int i = 0; i < res.length; i++) {
            ans = (ans + res[i]) % 1000000000;
        }

        System.out.println(ans);
    }

}
