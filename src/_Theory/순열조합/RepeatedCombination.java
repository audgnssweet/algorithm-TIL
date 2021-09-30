package _Theory.순열조합;

import java.util.Arrays;

public class RepeatedCombination {

    static int[] arr = { 1, 2, 3, 4, 5 };

    private static void makeOverlabCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeOverlabCombination(r, temp, current + 1, i);
            }
        }
    }
}
