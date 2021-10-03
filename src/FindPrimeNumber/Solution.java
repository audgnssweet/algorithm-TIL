package FindPrimeNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static char[] chars;
    static boolean[] visit;
    static List<Integer> nums = new ArrayList<>();

    public static int solution(String numbers) {

        return 0;
    }

    static void permutation(int n, LinkedList<Character> temp, int curCount, boolean[] visit) {
        if (curCount != 0) {
            System.out.println(temp);
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visit[i]) {
                visit[i] = true;

                temp.addLast(chars[i]);
                permutation(n, temp, curCount + 1, visit);
                temp.pollLast();

                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        chars = new char[]{'a', 'b', 'c'};

        permutation(3, new LinkedList<>(), 0, new boolean[3]);
    }
}
