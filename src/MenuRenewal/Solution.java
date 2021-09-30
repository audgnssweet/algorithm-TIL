package MenuRenewal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    static Map<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        for (String str : orders) {
            for (int i : course) {
                combination(i, new char[i], str, 0, 0);
            }
        }

        List<String> removes = new LinkedList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                removes.add(key);
            }
        }
        removes.forEach(rem -> map.remove(rem));

        List<String> res = new LinkedList<>();
        for (int i : course) {
            int curMax = 0;
            List<String> temp = new LinkedList<>();

            for (String key : map.keySet()) {
                if (key.length() == i) {
                    int curCount = map.get(key);
                    if (curCount > curMax) {
                        temp.clear();
                        temp.add(key);
                        curMax = curCount;
                    } else if (curCount == curMax) {
                        temp.add(key);
                    }
                }
            }

            res.addAll(temp);
        }

        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    public static void combination(int target, char[] temp, String str, int curCount, int start) {
        if (curCount == target) {
            char[] temp2 = Arrays.copyOf(temp, temp.length);
            Arrays.sort(temp2);
            String cur = new String(temp2);
            int count = map.getOrDefault(cur, 0);
            map.put(cur, count + 1);
        } else {
            for (int i = start; i < str.length(); i++) {
                temp[curCount] = str.charAt(i);
                combination(target, temp, str, curCount + 1, i + 1);
            }
        }
    }

}
