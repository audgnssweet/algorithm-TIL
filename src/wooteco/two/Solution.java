package wooteco.two;

public class Solution {

    public static String solution(String[] log) {
        int[] mins = new int[log.length];

        for (int i = 0; i < log.length; i++) {
            String[] split = log[i].split(":");
            int hour = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);

            mins[i] = hour * 60 + min;
        }

        int total = 0;
        for (int i = 0; i < mins.length - 1; i += 2) {
            int temp = mins[i + 1] - mins[i];

            if (temp >= 105) {
                total += 105;
            } else if (temp >= 5) {
                total += temp;
            }
        }

        int hour = total / 60;
        int min = total % 60;

        return String.format("%02d:%02d", hour, min);
    }

}
