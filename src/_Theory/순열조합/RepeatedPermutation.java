package _Theory.순열조합;

import java.util.Arrays;

public class RepeatedPermutation {

    static int[] arr = { 1, 2, 3, 4, 5 };

    private static void makeOverlabPermutation(int r, int[] temp, int current) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                makeOverlabPermutation(r, temp, current + 1);
            }
        }
    }
}
