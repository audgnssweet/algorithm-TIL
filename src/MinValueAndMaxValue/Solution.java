package MinValueAndMaxValue;

public class Solution {

    public String solution(String s) {
        String[] split = s.split(" ");
        int max = Integer.parseInt(split[0]), min = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; ++i) {
            max = Math.max(max, Integer.parseInt(split[i]));
            min = Math.min(min, Integer.parseInt(split[i]));
        }

        return min + " " + max;
    }
}
