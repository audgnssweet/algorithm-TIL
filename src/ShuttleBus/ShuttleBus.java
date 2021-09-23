package ShuttleBus;

import java.time.LocalTime;
import java.util.Arrays;

public class ShuttleBus {

    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        int time = 9, min = 0;
        int idx = 0;
        int count = 0;
        String curTime = null;

        for (int stg = 1; stg <= n; stg++) {

            curTime = LocalTime.of(time, min).toString();
            count = 0;
            while (count < m && idx < timetable.length && curTime.compareTo(timetable[idx]) >= 0) {
                count += 1;
                idx += 1;
            }

            min += t;
            if (min >= 60) {
                min -= 60;
                time += 1;
            }
        }

        if (count < m) {
            return curTime;
        } else {
            String[] split = timetable[idx - 1].split(":");
            return LocalTime.of(
                    Integer.parseInt(split[1]) != 0 ? Integer.parseInt(split[0]) : Integer.parseInt(split[0]) - 1,
                    Integer.parseInt(split[1]) != 0 ? Integer.parseInt(split[1]) - 1 : 59
                )
                .toString();
        }
    }
}
