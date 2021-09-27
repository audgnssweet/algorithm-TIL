package ThanksgivingTraffic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FailSolution {

    public int solution(String[] lines) {
        String regex = "^2016-09-15 (.*)s$";
        Pattern pattern = Pattern.compile(regex);
        String[][] terms = new String[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            Matcher matcher = pattern.matcher(lines[i]);

            if (matcher.find()) {
                String tmp = matcher.group(1);
                String[] s = tmp.split(" ");
                String[] nums = s[0].split(":");

                int time = Integer.parseInt(nums[0]);
                int minute = Integer.parseInt(nums[1]);
                double sec = Double.parseDouble(nums[2]);
                double dur = Double.parseDouble(s[1]);

                double temp = sec - (dur - 0.001);
                sec = temp < 0.0 ? 60.0 + sec - (dur - 0.001) : temp;
                sec = Math.round(sec * 1000) / 1000.0;
                if (temp < 0.0) {
                    if (minute == 0) {
                        minute = 59;
                        time -= 1;
                    } else {
                        minute -= 1;
                    }
                }

                String start = String.format("%02d:%02d:%06.3f", time, minute, sec);
                terms[i][0] = start;
            }
        }

        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            terms[i][1] = split[1];
        }

        int res = 0;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < terms.length; i++) {
                String[] nums = terms[i][k].split(":");

                int time = Integer.parseInt(nums[0]);
                int minute = Integer.parseInt(nums[1]);
                double sec = Double.parseDouble(nums[2]);

                double temp = sec + 0.999;
                sec = sec > 60.0 ? temp - 60.0 : temp;
                sec = Math.round(sec * 1000) / 1000.0;
                if (temp > 60.0) {
                    if (minute == 59) {
                        minute = 0;
                        time += 1;
                    } else {
                        minute += 1;
                    }
                }

                String curStart = terms[i][k];
                String curEnd = String.format("%02d:%02d:%06.3f", time, minute, sec);
                int curcnt = 0;
                for (int j = 0; j < terms.length; j++) {
                    if (curStart.compareTo(terms[j][1]) > 0 || curEnd.compareTo(terms[j][0]) < 0) {
                        continue;
                    }
                    curcnt += 1;
                }
                res = Math.max(res, curcnt);
            }
        }

        return res;
    }
}
