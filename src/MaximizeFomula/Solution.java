package MaximizeFomula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static char[] operators = new char[]{'+', '-', '*'};
    static List<char[]> pers = new ArrayList<>();

    public static long solution(String expression) {
        permutation(3, new char[3], 0, new boolean[3]);

        List<Long> nums = new ArrayList<>();
        for (String s : expression.split("[^\\d]")) {
            nums.add(Long.parseLong(s));
        }

        List<String> opers = new ArrayList<>();
        String[] split = expression.split("(\\d+)");
        for (int i = 1; i < split.length; i++) {
            opers.add(split[i]);
        }

        long max = 0;
        for (char[] per : pers) {
            max = Math.max(max, Math.abs(calc(
                per, new LinkedList<>(nums), new LinkedList<>(opers)
            )));
        }

        return max;
    }

    public static long calc(char[] per, List<Long> nums, List<String> opers) {
        for (int i = 0; i < per.length; i++) {
            for (int j = 0; j < opers.size(); j++) {
                if (opers.get(j).charAt(0) == per[i]) {

                    opers.remove(j);

                    long first = nums.remove(j);
                    long second = nums.remove(j);

                    nums.add(j, getCalc(first, second, per[i]));
                    //이게 핵심
                    --j;
                }
            }
        }
        return nums.get(0);
    }

    public static long getCalc(long first, long second, char oper) {
        switch (oper) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            default:
                return first * second;
        }
    }

    public static void permutation(int target, char[] temp, int curCount, boolean[] visit) {
        if (curCount == target) {
            pers.add(Arrays.copyOf(temp, temp.length));
        } else {
            for (int i = 0; i < operators.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    temp[curCount] = operators[i];
                    permutation(target, temp, curCount + 1, visit);
                    visit[i] = false;
                }
            }
        }
    }
}
