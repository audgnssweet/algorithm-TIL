package wooteco.six;

public class Solution {

    public static String solution(double time, String[][] plans) {
        String last = "호치민";
        for (String[] plan : plans) {
            double curNecessary = 0;
            curNecessary += getBeforeNecessary(plan[1]);
            curNecessary += getAfterNecessary(plan[2]);

            if (time - curNecessary >= 0) {
                last = plan[0];
                time -= curNecessary;
            } else {
                break;
            }
        }
        return last;
    }

    private static double getBeforeNecessary(String s) {
        int before = getTime(s);

        if (before <= 13) {
            return 5;
        } else if (before < 18) {
            return 18 - before;
        }
        return 0;
    }

    private static double getAfterNecessary(String s) {
        int after = getTime(s);

        if (after >= 18) {
            return 8.5;
        } else if (after >= 9.5) {
            return after - 9.5;
        }
        return 0;
    }

    private static int getTime(String s) {
        int before = Integer.parseInt(s.substring(0, s.length() - 2));
        String AMPM = s.substring(s.length() - 2);
        if (AMPM.equals("PM")) {
            before += 12;
        }
        return before;
    }
}
