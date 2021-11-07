package _Theory.순열조합;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    static int[] arr = { 1, 2, 3, 4, 5 };
    static List<String> res = new LinkedList<>();

    public static void main(String[] args) {
        permutation(3, new int[3], 0, new boolean[arr.length]);
    }

    public static void permutation(int target, int[] temp, int curCount, boolean[] visited) {
        if (curCount == target) {
            System.out.println(Arrays.toString(temp));
            res.add(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[curCount] = arr[i];
                    permutation(target, temp, curCount + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
