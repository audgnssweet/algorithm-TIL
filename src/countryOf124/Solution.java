package countryOf124;

import java.util.LinkedList;

public class Solution {

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        LinkedList<Integer> list = new LinkedList<>();

        while (n != 0) {
            list.add(n % 3);
            n /= 3;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= 0) {
                list.set(i, list.get(i) + 3);
                list.set(i + 1, list.get(i + 1) - 1);
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == 3) {
                list.set(i, 4);
            }
        }

        if (list.getLast() == 0) {
            list.removeLast();
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
