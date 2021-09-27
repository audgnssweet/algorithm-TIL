package ThanksgivingTraffic;

import java.util.PriorityQueue;

public class Solution {

    public enum TType {
        START(0), END(1);
        private int value;

        TType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class TimeMark implements Comparable<TimeMark> {

        int time;
        TType type;

        TimeMark(int time, TType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(TimeMark o) {
            if (this.time != o.time) {
                return this.time - o.time;
            }
            return this.type.getValue() - o.type.getValue();
        }
    }

    public static int solution(String[] lines) {
        PriorityQueue<TimeMark> pq = new PriorityQueue<>();

        for (String line : lines) {
            String[] parts = line.split(" ");
            String[] strEnds = parts[1].split("[:.]");

            int end = Integer.parseInt(strEnds[0]);
            end = end * 60 + Integer.parseInt(strEnds[1]);
            end = end * 60 + Integer.parseInt(strEnds[2]);
            end = end * 1000 + Integer.parseInt(strEnds[3]);

            pq.add(new TimeMark(end + 999, TType.END));
            String strTime = String.format("%-4s", parts[2].replaceAll("[.s]", "")).replace(' ', '0');

            int start = end - Integer.parseInt(strTime) + 1;
            pq.add(new TimeMark(start, TType.START));
        }

        int maxCnt = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            TimeMark tm = pq.poll();
            if (tm.type == TType.START) {
                ++cnt;
            } else {
                --cnt;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

}
