package _Theory.순열조합;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination {

    static int[] arr = { 1, 2, 3, 4, 5 };
    static List<String> res = new LinkedList<>();

    public static void main(String[] args) {
        combination(2, new int[2], 0, 0);

        res.forEach(System.out::println);
    }

    public static void combination(int target, int[] temp, int curCount, int start) {
        if (curCount == target) {
            res.add(Arrays.toString(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[curCount] = arr[i];
                combination(target, temp, curCount + 1, i + 1);
            }
        }
    }
}
